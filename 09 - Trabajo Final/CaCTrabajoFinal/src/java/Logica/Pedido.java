
package Logica;


public class Pedido {
    private String nombreCliente;
    private String apellidoCliente;
    private String email;
    private String lugarEntrega;
    private String localidad;
    private String provincia;
    private String codPostal;

    public Pedido() {
    }

    public Pedido(String nombreCliente, String apellidoCliente, String email, String lugarEntrega, String localidad, String provincia, String codPostal) {
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.email = email;
        this.lugarEntrega = lugarEntrega;
        this.localidad = localidad;
        this.provincia = provincia;
        this.codPostal = codPostal;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLugarEntrega() {
        return lugarEntrega;
    }

    public void setLugarEntrega(String lugarEntrega) {
        this.lugarEntrega = lugarEntrega;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(String codPostal) {
        this.codPostal = codPostal;
    }
           
    
    
    
}
