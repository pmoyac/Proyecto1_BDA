package DTOs;

/**
 *
 * @author Pedro Moya, Adriana Gutiérrez
 */
public class TransferenciaDTO {
    
    String fechaHora;
    float monto;
    int cuentaOrigen, cuentaDestino;
    int idCuenta;

    public TransferenciaDTO() {
    }

    public TransferenciaDTO(String fechaHora, float monto, int cuentaOrigen, int cuentaDestino, int idCuenta) {
        this.fechaHora = fechaHora;
        this.monto = monto;
        this.cuentaOrigen = cuentaOrigen;
        this.cuentaDestino = cuentaDestino;
        this.idCuenta = idCuenta;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public int getCuentaOrigen() {
        return cuentaOrigen;
    }

    public void setCuentaOrigen(int cuentaOrigen) {
        this.cuentaOrigen = cuentaOrigen;
    }

    public int getCuentaDestino() {
        return cuentaDestino;
    }

    public void setCuentaDestino(int cuentaDestino) {
        this.cuentaDestino = cuentaDestino;
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }
    
    public boolean esValido(){

        return true;
    }
    
    
}
