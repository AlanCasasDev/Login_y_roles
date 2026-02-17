package persistencia.DAO;

import logica.entidades.Usuario;
import persistencia.DAO.exceptions.NonexistentEntityException;
import persistencia.DAO.exceptions.RollbackFailureException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

public class UsuarioJPAController implements Serializable {

    // Fábrica de EntityManager (una por unidad de persistencia)
    private EntityManagerFactory emf = null;

    public UsuarioJPAController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public UsuarioJPAController() {
        this.emf = Persistence.createEntityManagerFactory("LoginJPAPU"); //MODIFICADO pero no se recomienda usar
    }

    /*Devuelve un EntityManager nuevo*/
    private EntityManager getEntityManager() {
        if (emf == null) {
            throw new IllegalStateException("EntityManagerFactory no inicializado.");
        }
        return emf.createEntityManager();
    }

    // CREATE
    public void create(Usuario usuario) throws RollbackFailureException {
        EntityManager em = null;

        try {
            // Se obtiene el EntityManager
            em = getEntityManager();

            // Se inicia la transacción
            em.getTransaction().begin();

            // Se persiste la entidad
            em.persist(usuario);

            // Se confirma la transacción
            em.getTransaction().commit();

        } catch (Exception ex) {
            // Si algo falla y la transacción sigue activa, rollback
            if (em != null && em.getTransaction().isActive()) {
                try {
                    em.getTransaction().rollback();
                } catch (Exception rbEx) {
                    throw new RollbackFailureException(
                            "Error al hacer rollback en create Usuario", rbEx
                    );
                }
            }
            throw new RollbackFailureException(
                    "Error al crear Usuario", ex
            );
        } finally {
            // Siempre cerrar el EntityManager
            if (em != null) {
                em.close();
            }
        }
    }

    // EDIT
    public void edit(Usuario usuario)
            throws NonexistentEntityException, RollbackFailureException {

        EntityManager em = null;

        try {
            em = getEntityManager();
            em.getTransaction().begin();

            // merge sincroniza el objeto con la BD
            usuario = em.merge(usuario);

            em.getTransaction().commit();

        } catch (Exception ex) {
            // Si el ID no existe en la BD
            if (findUsuario(usuario.getId()) == null) {
                throw new NonexistentEntityException(
                        "El usuario con id " + usuario.getId() + " no existe."
                );
            }

            // Manejo de rollback
            if (em != null && em.getTransaction().isActive()) {
                try {
                    em.getTransaction().rollback();
                } catch (Exception rbEx) {
                    throw new RollbackFailureException(
                            "Error al hacer rollback en edit Usuario", rbEx
                    );
                }
            }
            throw new RollbackFailureException(
                    "Error al editar Usuario", ex
            );
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // DESTROY
    public void destroy(long id)
            throws NonexistentEntityException, RollbackFailureException {

        EntityManager em = null;

        try {
            em = getEntityManager();
            em.getTransaction().begin();

            Usuario usuario;

            try {
                // getReference evita traer toda la entidad
                usuario = em.getReference(Usuario.class, id);
                usuario.getId(); // fuerza la carga
            } catch (Exception e) {
                throw new NonexistentEntityException(
                        "El usuario con id " + id + " no existe."
                );
            }

            // Se elimina la entidad
            em.remove(usuario);

            em.getTransaction().commit();

        } catch (Exception ex) {
            if (em != null && em.getTransaction().isActive()) {
                try {
                    em.getTransaction().rollback();
                } catch (Exception rbEx) {
                    throw new RollbackFailureException(
                            "Error al hacer rollback en destroy Usuario", rbEx
                    );
                }
            }
            throw new RollbackFailureException(
                    "Error al eliminar Usuario", ex
            );
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // FIND ONE
    public Usuario findUsuario(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Usuario.class, id);
        } finally {
            em.close();
        }
    }

    // FIND ALL
    public List<Usuario> findUsuarioEntities() {
        return findUsuarioEntities(true, -1, -1);
    }

    // FIND WITH PAGINATION
    public List<Usuario> findUsuarioEntities(int maxResults, int firstResult) {
        return findUsuarioEntities(false, maxResults, firstResult);
    }

    /*Método interno reutilizable para búsquedas*/
    private List<Usuario> findUsuarioEntities(
            boolean all, int maxResults, int firstResult) {

        EntityManager em = getEntityManager();

        try {
            // Criteria API (tipado y seguro)
            CriteriaQuery<Usuario> cq
                    = em.getCriteriaBuilder().createQuery(Usuario.class);

            cq.select(cq.from(Usuario.class));

            Query q = em.createQuery(cq);

            // Paginación
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }

            return q.getResultList();

        } finally {
            em.close();
        }
    }

    // COUNT
    public int getUsuarioCount() {
        EntityManager em = getEntityManager();

        try {
            CriteriaQuery<Long> cq
                    = em.getCriteriaBuilder().createQuery(Long.class);

            Root<Usuario> rt = cq.from(Usuario.class);
            cq.select(em.getCriteriaBuilder().count(rt));

            Query q = em.createQuery(cq);

            return ((Long) q.getSingleResult()).intValue();

        } finally {
            em.close();
        }
    }

    //Encontrar usuario por user y pass
    public Usuario findByUserAndPassword(String user, String password) {

        EntityManager em = getEntityManager();

        try {
            // JPQL: usamos la entidad Usuario y sus atributos
            TypedQuery<Usuario> query = em.createQuery(
                    "SELECT u FROM Usuario u WHERE u.user = :user AND u.password = :password",
                    Usuario.class
            );

            // Asignamos parámetros
            query.setParameter("user", user);
            query.setParameter("password", password);

            // getSingleResult devuelve UN usuario o lanza excepción
            return query.getSingleResult();

        } catch (NoResultException e) {
            // Si no hay resultados, login inválido
            return null;

        } finally {
            em.close(); // SIEMPRE cerrar
        }
    }

    //Encontrar ultimo id usuario
    public Long findUltimoIdUsuario() {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery(
                    "SELECT MAX(u.id) FROM Usuario u",
                    Long.class
            ).getSingleResult();
        } finally {
            em.close();
        }
    }

    //Ordenar y encontrar ultimo usuario
    public Usuario findUltimoUsuario() {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery(
                    "SELECT u FROM Usuario u ORDER BY u.id DESC",
                    Usuario.class
            ).setMaxResults(1)
                    .getSingleResult();
        } finally {
            em.close();
        }
    }

}
