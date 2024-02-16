package objetos;

import java.sql.Date;

/**
 * @author Pedro Moya, Adriana Gutiérrez
 */
public class Cliente {
    
    int id;
    String nombre, apellido_paterno, apellido_materno;
    String contrasenia;
    int edad;
    Date fecha_nacimiento;
    String calle, num, colonia;

    public Cliente() {
    }

    public Cliente(int id) {
        this.id = id;
    }

    public Cliente(int id, String nombre, String apellido_paterno, String apellido_materno, String contrasenia, int edad, Date fecha_nacimiento, String calle, String num, String colonia) {
        this.id = id;
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.contrasenia = contrasenia;
        this.edad = edad;
        this.fecha_nacimiento = fecha_nacimiento;
        this.calle = calle;
        this.num = num;
        this.colonia = colonia;
    }

    public Cliente(String nombre, String apellido_paterno, String apellido_materno, String contrasenia, int edad, Date fecha_nacimiento, String calle, String num, String colonia) {
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.contrasenia = contrasenia;
        this.edad = edad;
        this.fecha_nacimiento = fecha_nacimiento;
        this.calle = calle;
        this.num = num;
        this.colonia = colonia;
    }

    public Cliente(String nombre, String apellido_paterno, String apellido_materno, Date fecha_nacimiento,String contrasenia, String calle, String num, String colonia) {
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.fecha_nacimiento = fecha_nacimiento;
        this.contrasenia = contrasenia;
        this.calle = calle;
        this.num = num;
        this.colonia = colonia;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nombre=" + nombre + ", apellido_paterno=" + apellido_paterno + ", apellido_materno=" + apellido_materno + ", contrasenia=" + contrasenia + ", edad=" + edad + ", fecha_nacimiento=" + fecha_nacimiento + ", calle=" + calle + ", num=" + num + ", colonia=" + colonia + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.id;
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
        final Cliente other = (Cliente) obj;
        return this.id == other.id;
    }
    
}
