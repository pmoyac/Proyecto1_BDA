package objetos;

/**
 *
 * @author Pedro Moya, Adriana Gutiérrez
 */
public class Retiro {
    
    String folio;
    int contrasenia;
    float monto;
    int idCuenta;
    String estado;

    public Retiro() {
    }

    public Retiro(String folio, int contrasenia, float monto, int idCuenta) {
        this.folio = folio;
        this.contrasenia = contrasenia;
        this.monto = monto;
        this.idCuenta = idCuenta;
    }

    public Retiro(String folio, int contrasenia) {
        this.folio = folio;
        this.contrasenia = contrasenia;
    }

    public Retiro(String folio, int contrasenia, float monto, int idCuenta, String estado) {
        this.folio = folio;
        this.contrasenia = contrasenia;
        this.monto = monto;
        this.idCuenta = idCuenta;
        this.estado = estado;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public int getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(int contrasenia) {
        this.contrasenia = contrasenia;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
