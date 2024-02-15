package objetos;

import java.sql.Date;

/**
 * @author Pedro Moya, Adriana Gutiérrez
 */
public class Cuenta {

    int numero_cuenta;
    float saldo;
    Date fecha_apertura;

    public Cuenta() {
    }

    public Cuenta(float saldo, Date fecha_apertura) {
        this.saldo = saldo;
        this.fecha_apertura = fecha_apertura;
    }

    public int getNumero_cuenta() {
        return numero_cuenta;
    }

    public void setNumero_cuenta(int numero_cuenta) {
        this.numero_cuenta = numero_cuenta;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public Date getFecha_apertura() {
        return fecha_apertura;
    }

    public void setFecha_apertura(Date fecha_apertura) {
        this.fecha_apertura = fecha_apertura;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.numero_cuenta;
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
        return this.numero_cuenta == other.numero_cuenta;
    }

    @Override
    public String toString() {
        return "Cuenta{" + "numero_cuenta=" + numero_cuenta + ", saldo=" + saldo + ", fecha_apertura=" + fecha_apertura + '}';
    }
    
    
}
