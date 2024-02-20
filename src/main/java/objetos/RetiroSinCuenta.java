package objetos;

/**
 *
 * @author Pedro Moya, Adriana Gutiérrez
 */
public class RetiroSinCuenta {
    private String folio;
    private int numeroCuenta;
    private String cantidad;
    private String estado;
    private int contraseña;
    private String fechaHora;
    private String fechaHoraRetirado;
    private String fechaHoraLimite;
    
    
    public RetiroSinCuenta(){
  
    }

    public RetiroSinCuenta(int numeroCuenta, String cantidad, int contraseña) {
        this.numeroCuenta = numeroCuenta;
        this.cantidad = cantidad;
        this.contraseña = contraseña;
    }
 

    public RetiroSinCuenta(String folio, int contraseña) {
        this.folio = folio;
        this.contraseña = contraseña;
    }
   
    public RetiroSinCuenta(String folio, int numeroCuenta, String cantidad, String estado, int contraseña, String fechaHora, String fechaHoraRetirado, String fechaHoraLimite) {
        this.folio = folio;
        this.numeroCuenta = numeroCuenta;
        this.cantidad = cantidad;
        this.estado = estado;
        this.contraseña = contraseña;
        this.fechaHora = fechaHora;
        this.fechaHoraRetirado = fechaHoraRetirado;
        this.fechaHoraLimite = fechaHoraLimite;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getContraseña() {
        return contraseña;
    }

    public void setContraseña(int contraseña) {
        this.contraseña = contraseña;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getFechaHoraRetirado() {
        return fechaHoraRetirado;
    }

    public void setFechaHoraRetirado(String fechaHoraRetirado) {
        this.fechaHoraRetirado = fechaHoraRetirado;
    }

    public String getFechaHoraLimite() {
        return fechaHoraLimite;
    }

    public void setFechaHoraLimite(String fechaHoraLimite) {
        this.fechaHoraLimite = fechaHoraLimite;
    }
}
