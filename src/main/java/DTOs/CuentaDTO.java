package DTOs;

/**
 *
 * @author adria
 */
public class CuentaDTO {
    
    private String fechaApertura;
    private String numeroCuenta;
    private String estadoCuenta;
    private double saldo;
    private Long idCliente;

    public CuentaDTO() {
    }

    public CuentaDTO(String fechaApertura, String numeroCuenta, String estadoCuenta, double saldo, Long idCliente) {
        this.fechaApertura = fechaApertura;
        this.numeroCuenta = numeroCuenta;
        this.estadoCuenta = estadoCuenta;
        this.saldo = saldo;
        this.idCliente = idCliente;
    }

    public String getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(String fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getEstadoCuenta() {
        return estadoCuenta;
    }

    public void setEstadoCuenta(String estadoCuenta) {
        this.estadoCuenta = estadoCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }
    
//    public boolean esValido(){
//        if(this.fechaApertura == null || this.fechaApertura.isBlank()
//            || this.numeroCuenta == null || this.numeroCuenta.isBlank()
//            || this.estadoCuenta == null || this.estadoCuenta.isBlank()
//            || this.idCliente == null || this.idCliente
//            )
//        {
//            
//        }
//    }
    
}
