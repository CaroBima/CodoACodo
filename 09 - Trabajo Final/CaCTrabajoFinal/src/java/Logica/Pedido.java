
package Logica;


public class Pedido {
    private String nombreCliente;
    private String apellidoCliente;
    private String nombreUsuario;
    private String email;
    private String lugarEntrega;
    private String localidad;
    private String provincia;
    private int codPostal;
    private String formaPago;
    private String nombreTitularTC;
    private String numeroTarjeta;
    private String fechaVenc;
    private int codSeguridadTC;

    public Pedido() {
    }

    public Pedido(String nombreCliente, String apellidoCliente, String nombreUsuario, String email, String lugarEntrega, String localidad, String provincia, int codPostal, String formaPago, String nombreTitularTC, String numeroTarjeta, String fechaVenc, int codSeguridadTC) {
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.lugarEntrega = lugarEntrega;
        this.localidad = localidad;
        this.provincia = provincia;
        this.codPostal = codPostal;
        this.formaPago = formaPago;
        this.nombreTitularTC = nombreTitularTC;
        this.numeroTarjeta = numeroTarjeta;
        this.fechaVenc = fechaVenc;
        this.codSeguridadTC = codSeguridadTC;
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

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
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

    public int getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(int codPostal) {
        this.codPostal = codPostal;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public String getNombreTitularTC() {
        return nombreTitularTC;
    }

    public void setNombreTitularTC(String nombreTitularTC) {
        this.nombreTitularTC = nombreTitularTC;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getFechaVenc() {
        return fechaVenc;
    }

    public void setFechaVenc(String fechaVenc) {
        this.fechaVenc = fechaVenc;
    }

    public int getCodSeguridadTC() {
        return codSeguridadTC;
    }

    public void setCodSeguridadTC(int codSeguridadTC) {
        this.codSeguridadTC = codSeguridadTC;
    }

    
}

   