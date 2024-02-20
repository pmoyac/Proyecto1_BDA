package datos;

import excepciones.PersistenciaException;
import interfaces.IConexion;
import interfaces.ICuenta;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import objetos.Cuenta;

/**
 * @author Pedro Moya, Adriana Gutiérrez
 */
public class CuentaDAO implements ICuenta {

    private final IConexion conexion;

    public CuentaDAO() {
        this.conexion = new ConexionBD();
    }

    @Override
    public Cuenta agregarCuenta(Cuenta c) throws PersistenciaException {
        String agregarCuenta = "INSERT INTO cuentas (numero_cuenta, saldo, fecha_apertura) VALUES (?, ?, ?)";

        Connection con;
        try {
            con = conexion.crearConexion();
            PreparedStatement insert = con.prepareStatement(agregarCuenta);
            insert.setInt(1, c.getNumero_cuenta());
            insert.setFloat(2, c.getSaldo());
            insert.setDate(3, c.getFecha_apertura());
            insert.executeUpdate();

            //ResultSet res = insert.getGeneratedKeys();
        } catch (SQLException ex) {
            //Logger.getLogger(CuentaDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("No fue posible agregar la cuenta");
        }
        return null;

    }

    @Override
    public Cuenta eliminaCuenta(int numero_cuenta) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Cuenta transferir(int nc1, int nc2, float monto) throws PersistenciaException {
        String procedureCall = "{call transferir(?, ?, ?)}";
        Connection con;

        try {
            con = conexion.crearConexion();
            CallableStatement callableStatement = con.prepareCall(procedureCall);
            callableStatement.setInt(1, nc1);
            callableStatement.setInt(2, nc2);
            callableStatement.setDouble(3, monto);

            callableStatement.executeUpdate();
            System.out.println("Transferencia Completada");
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();

        }
        return null;
    }

    @Override
    public Cuenta generarRetiro(int nc, float monto) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Cuenta> buscarCuentas(int idCliente) throws PersistenciaException {
       
        List<Cuenta> lcu = new ArrayList<>();
        String agregarCuenta = "SELECT * FROM cuentas WHERE id_cliente = ?";

        Connection con;
        try {
            con = conexion.crearConexion();
            PreparedStatement insert = con.prepareStatement(agregarCuenta);
            insert.setInt(1, idCliente);

            ResultSet res = insert.executeQuery();

            while (res.next()) {
                int id = res.getInt("numero_cuenta");
                float saldo = res.getFloat("saldo");
                Date fecha = res.getDate("fecha_apertura");
                int idcliente = res.getInt("id_cliente");

                Cuenta nueva = new Cuenta(id,saldo, fecha, idcliente);
                lcu.add(nueva);
            }

            return lcu;

        } catch (SQLException ex) {
            throw new PersistenciaException("No fue posible consultar las cuentas");
        }
    }

}
