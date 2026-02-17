
package logica.entidades;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="roles")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //por lo general recomiendo IDENTITY
    @Column(name = "id_rol", nullable = false)
    private int id;
    
    @Column(name ="nombre_rol", nullable = false, length = 50)
    private String nombreRol;
    
    @Column(name ="descripcion", nullable = false, length = 250)
    private String descripcion;
    
    @OneToMany(mappedBy = "unRol") //Se mapea con el atributo Rol unRol; de la clase Usuario
    private List<Usuario> usuarios;
    //private List<Usuario> usuarios = new ArrayList<>();
    

    
    public Rol() {
    }

    public Rol(String nombreRol, String descripcion, List<Usuario> usuarios) {        
        this.nombreRol = nombreRol;
        this.descripcion = descripcion;
        this.usuarios = usuarios;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }        
    
    
}
