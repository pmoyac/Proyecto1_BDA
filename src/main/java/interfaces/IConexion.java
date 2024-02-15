package interfaces;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Pedro Moya, Adriana Gutiérrez
 */
public interface IConexion {
    
    Connection crearConexion() throws SQLException;
    
}
