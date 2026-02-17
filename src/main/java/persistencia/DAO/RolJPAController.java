package persistencia.DAO;

import logica.entidades.Rol;
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


public class RolJPAController implements Serializable{
    
    // Fábrica de EntityManager (una por unidad de persistencia)
    private EntityManagerFactory emf = null;

    public RolJPAController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public RolJPAController() {
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
    public void create(Rol rol) throws RollbackFailureException {
        EntityManager em = null;

        try {
            // Se obtiene el EntityManager
            em = getEntityManager();

            // Se inicia la transacción
            em.getTransaction().begin();

            // Se persiste la entidad
            em.persist(rol);

            // Se confirma la transacción
            em.getTransaction().commit();

        } catch (Exception ex) {
            // Si algo falla y la transacción sigue activa, rollback
            if (em != null && em.getTransaction().isActive()) {
                try {
                    em.getTransaction().rollback();
                } catch (Exception rbEx) {
                    throw new RollbackFailureException(
                            "Error al hacer rollback en create Rol", rbEx
                    );
                }
            }
            throw new RollbackFailureException(
                    "Error al crear el Rol", ex
            );
        } finally {
            // Siempre cerrar el EntityManager
            if (em != null) {
                em.close();
            }
        }
    }

    // EDIT
    public void edit(Rol rol)
            throws NonexistentEntityException, RollbackFailureException {

        EntityManager em = null;

        try {
            em = getEntityManager();
            em.getTransaction().begin();

            // merge sincroniza el objeto con la BD
            rol = em.merge(rol);

            em.getTransaction().commit();

        } catch (Exception ex) {
            // Si el ID no existe en la BD
            if (findRol(rol.getId()) == null) {
                throw new NonexistentEntityException(
                        "El rol con id " + rol.getId() + " no existe."
                );
            }

            // Manejo de rollback
            if (em != null && em.getTransaction().isActive()) {
                try {
                    em.getTransaction().rollback();
                } catch (Exception rbEx) {
                    throw new RollbackFailureException(
                            "Error al hacer rollback en edit Rol", rbEx
                    );
                }
            }
            throw new RollbackFailureException(
                    "Error al editar Rol", ex
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

            Rol rol;

            try {
                // getReference evita traer toda la entidad
                rol = em.getReference(Rol.class, id);
                rol.getId(); // fuerza la carga
            } catch (Exception e) {
                throw new NonexistentEntityException(
                        "El rol con id " + id + " no existe."
                );
            }

            // Se elimina la entidad
            em.remove(rol);

            em.getTransaction().commit();

        } catch (Exception ex) {
            if (em != null && em.getTransaction().isActive()) {
                try {
                    em.getTransaction().rollback();
                } catch (Exception rbEx) {
                    throw new RollbackFailureException(
                            "Error al hacer rollback en destroy Rol", rbEx
                    );
                }
            }
            throw new RollbackFailureException(
                    "Error al eliminar Rol", ex
            );
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // FIND ONE
    public Rol findRol(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Rol.class, id);
        } finally {
            em.close();
        }
    }

    // FIND ALL
    public List<Rol> findRolEntities() {
        return findRolEntities(true, -1, -1);
    }

    // FIND WITH PAGINATION
    public List<Rol> findRolEntities(int maxResults, int firstResult) {
        return findRolEntities(false, maxResults, firstResult);
    }

    /*Método interno reutilizable para búsquedas*/
    private List<Rol> findRolEntities(
            boolean all, int maxResults, int firstResult) {

        EntityManager em = getEntityManager();

        try {
            // Criteria API (tipado y seguro)
            CriteriaQuery<Rol> cq
                    = em.getCriteriaBuilder().createQuery(Rol.class);

            cq.select(cq.from(Rol.class));

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
    public int getRolCount() {
        EntityManager em = getEntityManager();

        try {
            CriteriaQuery<Long> cq
                    = em.getCriteriaBuilder().createQuery(Long.class);

            Root<Rol> rt = cq.from(Rol.class);
            cq.select(em.getCriteriaBuilder().count(rt));

            Query q = em.createQuery(cq);

            return ((Long) q.getSingleResult()).intValue();

        } finally {
            em.close();
        }
    }
    
}
