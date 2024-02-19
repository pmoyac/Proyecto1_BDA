package DTOs;

/**
 *
 * @author adria
 */
public class ClienteDTO {
    
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String usuario;
    private String contrasena;
    private String fechaNacimiento;
    private String calle, numeroExterior, colonia;

    public ClienteDTO() {
    }

    public ClienteDTO(String nombre, String apellidoPaterno, String apellidoMaterno, String usuario, String contrasena, String fechaNacimiento, String calle, String numeroExterior, String colonia) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.fechaNacimiento = fechaNacimiento;
        this.calle = calle;
        this.numeroExterior = numeroExterior;
        this.colonia = colonia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumeroExterior() {
        return numeroExterior;
    }

    public void setNumeroExterior(String numeroExterior) {
        this.numeroExterior = numeroExterior;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }
    
    public boolean esValido() {
        if (this.nombre == null || this.nombre.isBlank()
                || this.apellidoPaterno == null || this.apellidoPaterno.isBlank()
                || this.apellidoMaterno == null || this.apellidoMaterno.isBlank()
                || this.fechaNacimiento == null || this.fechaNacimiento.isBlank() 
                || this.calle == null || this.calle.isBlank()
                || this.numeroExterior == null || this.numeroExterior.isBlank()
                || this.colonia == null || this.colonia.isBlank()
                || this.usuario == null || this.usuario.isBlank()
                || this.contrasena == null || this.contrasena.isBlank()
                )
        {
            return false;
        }
        return true;
    }
    
}
