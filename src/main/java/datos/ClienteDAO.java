package datos;

import excepciones.PersistenciaException;
import interfaces.ICliente;
import interfaces.IConexion;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.Date;
//import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetos.Cliente;
import objetos.Encripta;

/**
 * @author Pedro Moya, Adriana Gutiérrez
 */
public class ClienteDAO implements ICliente {

    private final IConexion conexion;
    private static final Logger LOG = Logger.getLogger(ClienteDAO.class.getName());
    Encripta encripta;

    public ClienteDAO() throws NoSuchAlgorithmException {
        this.conexion = new ConexionBD();
        this.encripta = new Encripta();
    }

    @Override
    public Cliente registrarCliente(Cliente c) throws PersistenciaException {
        String createClient = "INSERT INTO clientes "
                + "(contrasenia, nombre, apellido_paterno, apellido_materno, fecha_nacimiento, calle, num, colonia) "
                + "VALUES (?,?,?,?,?,?,?,?)";

        Cliente resultado = null;

        try {

            Connection cn = conexion.crearConexion();

            String contra = encripta.encripta(c.getContrasenia());

            PreparedStatement insert = cn.prepareStatement(createClient, Statement.RETURN_GENERATED_KEYS);

            insert.setString(1, contra);
            insert.setString(2, c.getNombre());
            insert.setString(3, c.getApellido_paterno());
            insert.setString(4, c.getApellido_materno());
            insert.setDate(5, c.getFecha_nacimiento());
            insert.setString(6, c.getCalle());
            insert.setString(7, c.getNum());
            insert.setString(8, c.getColonia());

            insert.executeUpdate();

            // Obtener el ID generado por la base de datos
            ResultSet rs = insert.getGeneratedKeys();
            if (rs.next()) {
                int idGenerado = rs.getInt(1);
                c.setId(idGenerado); // Establecer el ID generado en el cliente
            }

            resultado = c;
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
            throw new PersistenciaException("No fue posible agregar el cliente" + e.getMessage());
        }
        return resultado;
    }

    public int obtenerIdClienteGenerado() throws PersistenciaException {
        int idGenerado = -1;
        try {
            ResultSet rs = obtenerResultSetConUltimaClaveGenerada();
            if (rs.next()) {
                idGenerado = rs.getInt(1);
            }
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
            throw new PersistenciaException("No fue posible obtener el ID del cliente generado: " + e.getMessage());
        }
        return idGenerado;
    }

    private ResultSet obtenerResultSetConUltimaClaveGenerada() throws SQLException {
        Connection cn = conexion.crearConexion();
        Statement stmt = cn.createStatement();
        return stmt.executeQuery("SELECT LAST_INSERT_ID()");
    }

    @Override
    public Cliente actualizarCliente(Cliente c) throws PersistenciaException {

        String createClient = "UPDATE clientes SET "
                + "nombre = ?, apellido_paterno = ?, apellido_materno = ?, fecha_nacimiento = ?, "
                + "calle = ?, num = ?, colonia = ? WHERE id = ?";

        Cliente resultado = null;

        try {
            Connection cn = conexion.crearConexion();
            PreparedStatement insert = cn.prepareStatement(createClient, Statement.RETURN_GENERATED_KEYS);

            insert.setString(1, c.getNombre());
            insert.setString(2, c.getApellido_paterno());
            insert.setString(3, c.getApellido_materno());
            insert.setDate(4, c.getFecha_nacimiento());
            insert.setString(5, c.getCalle());
            insert.setString(6, c.getNum());
            insert.setString(7, c.getColonia());
            insert.setInt(8, c.getId());
            insert.executeUpdate();

            resultado = buscarCliente(c.getId());
            return resultado;

        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
            throw new PersistenciaException("No fue posible actualizar el cliente" + e.getMessage());
        }
    }

    @Override
    public Cliente buscarCliente(int id) throws PersistenciaException {

        String searchClient = "SELECT * FROM clientes"
                + " WHERE id=" + id;

        Cliente resultado = null;

        try {
            Connection c = conexion.crearConexion();
            PreparedStatement search = c.prepareStatement(searchClient);

            ResultSet res = search.executeQuery();

            if (res.next()) {
                int idc = res.getInt("id");
                String contrasenia = res.getString("contrasenia");
                String nombre = res.getString("nombre");
                String apellido_paterno = res.getString("apellido_Paterno");
                String apellido_materno = res.getString("apellido_Materno");
                Date fecha_nacimiento = res.getDate("fecha_nacimiento");

                String calle = res.getString("calle");
                String num = res.getString("num");
                String colonia = res.getString("colonia");

                resultado = new Cliente(idc, contrasenia, nombre, apellido_paterno, apellido_materno, fecha_nacimiento, calle, num, colonia);
                return resultado;
            }

        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
            throw new PersistenciaException("No fue posible buscar al cliente" + e.getMessage());
        }
        return resultado;
    }

    @Override
    public Cliente iniciarSesion(int idCliente, String contrasenia) throws PersistenciaException {

        String contra = this.buscarCliente(idCliente).getContrasenia();
        System.out.println(contra);
        String search = "SELECT * FROM clientes WHERE id = ? AND contrasenia = ?";

        Cliente cliente = null;
        try (Connection cn = conexion.crearConexion(); PreparedStatement ps = cn.prepareStatement(search)) {
            //Encripta encripta = new Encripta();
            String contraseniaEn = encripta.encripta(contrasenia);
            System.out.println(contraseniaEn);

            ps.setInt(1, idCliente);
            ps.setString(2, contraseniaEn);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    // Se encontró el cliente
                    cliente = new Cliente();
                    cliente.setId(rs.getInt("id"));
                    cliente.setContrasenia(rs.getString("contrasenia"));
                    cliente.setNombre(rs.getString("nombre"));
                    cliente.setApellido_paterno(rs.getString("apellido_paterno"));
                    cliente.setApellido_materno(rs.getString("apellido_materno"));
                    cliente.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
                    cliente.setCalle(rs.getString("calle"));
                    cliente.setNum(rs.getString("num"));
                    cliente.setColonia(rs.getString("colonia"));
                }
            }
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
            throw new PersistenciaException("Error al iniciar sesión: " + e.getMessage());
        }

        return cliente;
    }
}
