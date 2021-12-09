package Logica;

/**
 *
 * @author Caro
 */
public class Usuario {
    private String usuario;
    private String clave;
    private String nombreyapellido;

    public Usuario() {
    }

    public Usuario(String usuario, String clave, String nombreyapellido) {
        this.usuario = usuario;
        this.clave = clave;
        this.nombreyapellido = nombreyapellido;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombreyapellido() {
        return nombreyapellido;
    }

    public void setNombreyapellido(String nombreyapellido) {
        this.nombreyapellido = nombreyapellido;
    }
    
    
}
