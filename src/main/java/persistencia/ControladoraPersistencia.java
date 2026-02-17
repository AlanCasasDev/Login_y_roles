package persistencia;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import logica.entidades.Rol;
import logica.entidades.Usuario;
import persistencia.DAO.RolJPAController;
import persistencia.DAO.UsuarioJPAController;
import persistencia.DAO.exceptions.NonexistentEntityException;
import persistencia.DAO.exceptions.RollbackFailureException;

public class ControladoraPersistencia {

    //modo 1
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("LoginJPAPU");
    private UsuarioJPAController userJPA = new UsuarioJPAController(emf);
    private RolJPAController rolJPA = new RolJPAController(emf);

    //modo 2
    private UsuarioJPAController userJPA1 = new UsuarioJPAController();
    private RolJPAController rolJPA1 = new RolJPAController();

    //crear/guardar usuario
    public boolean crearUsuario(Usuario usuario) {
        try {
            userJPA.create(usuario);
            return true;
        } catch (RollbackFailureException e) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, "Error al crear Usuario con Id: " + usuario.getId() + "/Usuario: " + usuario.getUser() + "/Rol: " + usuario.getRol().getNombreRol(), e);
            return false;
        }
    }
    
    //Encontrar un usuario por id
    public Usuario traerUsuario(long idUsuarioEditado) {
        try {
            return userJPA.findUsuario(idUsuarioEditado);
        } catch (Exception e) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, "Error al solicitar el usuario", e);
            return null;
        }
    }

    //Traer usuarios
    public List<Usuario> traerUsuarios() {
        try {
            return userJPA.findUsuarioEntities();
        } catch (Exception e) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, "Error solicitar la lista de usuarios", e);
            return null;
        }
    }

    //Borrar usuario
    public boolean borrarUsuario(Long id) {
        try {
            userJPA.destroy(id);
            return true;
        } catch (NonexistentEntityException e) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.WARNING, "Error: La entidad que desea borrar no existe. El id:" + id, e);
            return false;
        } catch (RollbackFailureException e) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, "Error de rollback al eliminar el usuariocon id:" + id, e);
            return false;
        } catch (Exception e) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, "Error inesperado al eliminar el usuario con id:" + id, e);
            return false;
        }
    }

    //Traer roles
    public List<Rol> traerRoles() {
        try {
            return rolJPA.findRolEntities();
        } catch (Exception e) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, "Error solicitar la lista de roles", e);
            return null;
        }
    }

    //Traer ultimo id de usuario
    public long traerUltimoIdUsuario() {
        return userJPA.findUltimoIdUsuario();
    }

    public boolean editarUsuario(Usuario usuarioEditado) {
        try{
            userJPA.edit(usuarioEditado);
            return true;
        } catch (NonexistentEntityException e) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.WARNING, "Error: La entidad que desea editar no existe.", e);
            return false;
        } catch (RollbackFailureException e) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, "Error de rollback al editar Usuario", e);            
            return false;
        } catch (Exception e) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, "Error inesperado al editar Usuario", e);                              
            return false;
        }
    }

}
