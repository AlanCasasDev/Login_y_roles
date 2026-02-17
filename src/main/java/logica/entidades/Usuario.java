
package logica.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //por lo general recomiendo IDENTITY
    @Column(name = "id_user", nullable = false)
    private long id;
    
    @Column(name ="user", nullable = false, length = 30)
    private String user;
    
    @Column(name ="pass", nullable = false, length = 50)
    private String password;
    
    @ManyToOne
    //La columna no puede ser igual a otra de la tabla. No podria ser name=id_user por ejemplo
    @JoinColumn(name = "fk_id_rol", nullable = false) //La fk vive del lado del usuario (se une con la columna id_rol de la clase ROL)
    private Rol unRol;

    public Usuario() {
    }

    public Usuario(String user, String password, Rol rol) {
        this.user = user;
        this.password = password;
        this.unRol = rol;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Rol getRol() {
        return unRol;
    }

    public void setRol(Rol rol) {
        this.unRol = rol;
    }
        

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", user=" + user + ", password=" + password + '}';
    }
    
    
}
