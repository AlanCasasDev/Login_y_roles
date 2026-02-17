package logica;

import java.util.List;
import logica.entidades.Rol;
import logica.entidades.Usuario;
import persistencia.ControladoraPersistencia;

public class ControladoraLogica {

    private ControladoraPersistencia persistControl = new ControladoraPersistencia();

    public Usuario validarUserPass(String user, String pass) {

        Usuario usuario = null;
        List<Usuario> listaUsuarios = persistControl.traerUsuarios();

        if (listaUsuarios == null || listaUsuarios.isEmpty()) {
            IO.println("No hay usuarios registrados en el sistema.");
            return null;
        }

        for (Usuario u : listaUsuarios) {
            if (u.getUser().equals(user)) {
                if (u.getPassword().equals(pass)) {
                    IO.println("Bienvenido! Usuario y contraseña correctos.");
                    return u;
                } else {
                    IO.println("Contraseña incorrecta.");
                    return null;
                }
            }
        }

        // SOLO si terminó el for y nunca encontró el usuario
        IO.println("El usuario no existe en la base de datos.");
        return usuario;
    }

    public boolean crearUsuario(String user, String pass, String rol) {
        Usuario usuario = new Usuario();
        List<Rol> roles = persistControl.traerRoles();

        usuario.setUser(user);
        usuario.setPassword(pass);

        if (roles != null) {
            for (Rol rl : roles) {
                if (rol.toLowerCase().equals(rl.getNombreRol().toLowerCase())) {
                    usuario.setRol(rl);
                }
            }
        }
        
        long id = this.buscarUltimoIdUsuario();
        usuario.setId(id+1);

        return persistControl.crearUsuario(usuario);
    }
    
    public Usuario traerUsuario(long idUsuarioEditado) {
        return persistControl.traerUsuario(idUsuarioEditado);
    }

    public List<Usuario> traerUsuarios() {
        return persistControl.traerUsuarios();
    }

    public boolean borrarUsuario(Long id) {
        return persistControl.borrarUsuario(id);
    }

    public List<Rol> traerRoles() {
        return persistControl.traerRoles();
    }

    private long buscarUltimoIdUsuario() {
        //No recomendable porque trae todos los usuarios, es mejor por query
        List<Usuario> listaUsuarios = persistControl.traerUsuarios();
                
        Long idUltimoUsuario =  listaUsuarios.stream()
                                .map(Usuario::getId)
                                .max(Long::compareTo)
                                .orElse(null);
        
        return idUltimoUsuario;
        
        //Opcion recomendada
        //return persistControl.traerUltimoIdUsuario();
    }

    public boolean editarUsuario(Usuario usuarioEditado) {
        return persistControl.editarUsuario(usuarioEditado);
    }


}
