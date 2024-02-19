package datos;

import DTOs.ClienteDTO;
import excepciones.PersistenciaException;
import interfaces.ICliente;
import interfaces.IConexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetos.Cliente;

/**
 * @author Pedro Moya, Adriana Gutiérrez
 */
public class ClienteDAO implements ICliente{
    
    private final IConexion conexion;
    static final Logger logger = Logger.getLogger(ClienteDAO.class.getName());


    public ClienteDAO(IConexion conexion) {
        this.conexion = conexion;
    } 

    @Override
    public Cliente registrarCliente(ClienteDTO clienteDTO) throws PersistenciaException {
        String createClient = """
                              INSERT INTO clientes (nombre, apellido_paterno, apellido_materno, usuario, contrasenia, fecha_nacimiento, calle, num, colonia) 
                              VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);
                              """;
        
        Cliente resultado=null;
        
        try (
            Connection conexion = this.conexion.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(createClient, Statement.RETURN_GENERATED_KEYS);
        ) {
            comando.setString(1, clienteDTO.getNombre());
            comando.setString(2, clienteDTO.getApellidoPaterno());
            comando.setString(3, clienteDTO.getApellidoMaterno());
            comando.setString(4, clienteDTO.getUsuario());
            comando.setString(5, clienteDTO.getContrasena());
            comando.setString(6, clienteDTO.getFechaNacimiento());
            comando.setString(7, clienteDTO.getCalle());
            comando.setString(8, clienteDTO.getNumeroExterior());
            comando.setString(9, clienteDTO.getColonia());
            
            int numeroRegistrosInsertados = comando.executeUpdate();
            logger.log(Level.INFO, "Se agregaron {0} clientes", numeroRegistrosInsertados);
            ResultSet idsGenerados = comando.getGeneratedKeys();
            idsGenerados.next();
     
            Cliente cliente = new Cliente(idsGenerados.getLong(1), clienteDTO.getNombre(), clienteDTO.getApellidoPaterno(), clienteDTO.getApellidoMaterno(), clienteDTO.getUsuario(),
            clienteDTO.getContrasena(), clienteDTO.getFechaNacimiento(), clienteDTO.getCalle(), clienteDTO.getNumeroExterior(), clienteDTO.getColonia());
            return cliente;
            
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "No se pudo registrar el usuario", e);
            throw new PersistenciaException("No se pudo", e);
        }    
    }

    @Override
    public Cliente actualizarCliente(ClienteDTO clienteDTO) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Cliente buscarCliente(int id) throws PersistenciaException {
        String searchClient = "SELECT * FROM clientes"
                + " WHERE id=" + id;
        
        System.out.println(searchClient);

        Cliente resultado = null;
        
        try {
            Connection c = conexion.crearConexion();
            PreparedStatement search = c.prepareStatement(searchClient);
           
            ResultSet res = search.executeQuery();
            
            if(res.next()){
                String nombre = res.getString("nombre");
                String apellido_paterno = res.getString("apellido_paterno");
                String apellido_materno = res.getString("apellido_materno");
                String usuario = res.getString("usuario");
                String contrasena = res.getString("contrasenia");
                String fecha_nacimiento = res.getString("fecha_nacimiento");
                String calle = res.getString("calle");
                String numeroExt = res.getString("num");
                String colonia = res.getString("colonia");
                
                resultado = new Cliente(nombre, apellido_paterno, apellido_materno, usuario,
                        contrasena, fecha_nacimiento, calle, numeroExt, colonia);
         //       return resultado;
            }
            
        } catch (SQLException e) {
            logger.log(Level.SEVERE, e.getMessage());
            throw new PersistenciaException("No fue posible buscar al cliente" + e.getMessage());
        }
        return resultado;

    }
    
}
