package datos;

import interfaces.IConexion;
import java.util.logging.Logger;

/**
 * @author Pedro Moya, Adriana Gutiérrez
 */
public class ClienteDAO {
    
    private final IConexion conexion;
    private static final Logger LOG = Logger.getLogger(ClienteDAO.class.getName());

    public ClienteDAO(IConexion conexion) {
        this.conexion = conexion;
    }
    
    
}
