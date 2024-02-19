package objetos;

import java.sql.Date;
import java.util.Objects;

/**
 * @author Pedro Moya, Adriana Gutiérrez
 */
public class Cuenta {

    private Long idCuenta;
    private String fechaApertura;
    private String numeroCuenta;
    private String estadoCuenta;
    private double saldo;
    private Long idCliente;
    
    public Cuenta() {
    }

    public Cuenta(Long idCuenta, String fechaApertura, String numeroCuenta, String estadoCuenta, double saldo, Long idCliente) {
        this.idCuenta = idCuenta;
        this.fechaApertura = fechaApertura;
        this.numeroCuenta = numeroCuenta;
        this.estadoCuenta = estadoCuenta;
        this.saldo = saldo;
        this.idCliente = idCliente;
    }

    public Cuenta(String fechaApertura, String numeroCuenta, String estadoCuenta, double saldo) {
        this.fechaApertura = fechaApertura;
        this.numeroCuenta = numeroCuenta;
        this.estadoCuenta = estadoCuenta;
        this.saldo = saldo;
    }

    public Long getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Long idCuenta) {
        this.idCuenta = idCuenta;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.idCuenta);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cuenta other = (Cuenta) obj;
        return Objects.equals(this.idCuenta, other.idCuenta);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cuenta{");
        sb.append("idCuenta=").append(idCuenta);
        sb.append(", fechaApertura=").append(fechaApertura);
        sb.append(", numeroCuenta=").append(numeroCuenta);
        sb.append(", estadoCuenta=").append(estadoCuenta);
        sb.append(", saldo=").append(saldo);
        sb.append(", idCliente=").append(idCliente);
        sb.append('}');
        return sb.toString();
    }

    
    
}
