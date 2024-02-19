package datos;

import interfaces.IConexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Pedro Moya, Adriana Gutiérrez
 */
public class ConexionBD implements IConexion{
    private String cadenaConexion;
    private String usuario;
    private String contrasena;

    
    public ConexionBD(String cadenaConexion, String usuario, String contrasena){
        this.cadenaConexion = cadenaConexion;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }
    
    @Override
    public Connection crearConexion() throws SQLException {
        Connection c = DriverManager.getConnection(cadenaConexion, usuario, contrasena);
        return c;
    }
}
