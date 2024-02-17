package datos;

import excepciones.PersistenciaException;
import interfaces.IConexion;
import interfaces.ICuenta;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import objetos.Cuenta;

/**
 * @author Pedro Moya, Adriana Gutiérrez
 */
public class CuentaDAO implements ICuenta{
    
    private final IConexion conexion;


    public CuentaDAO(IConexion conexion) {
        this.conexion = conexion;
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
        Connection con ;

        try  {
            con = conexion.crearConexion();
            CallableStatement callableStatement = con.prepareCall(procedureCall);
            callableStatement.setInt(1, nc1);
            callableStatement.setInt(2, nc2);
            callableStatement.setDouble(3, monto);

            callableStatement.executeUpdate();
            System.out.println("Funds transferred successfully.");
        } catch (SQLException e) {
            System.err.println("Error while executing the stored procedure: " + e.getMessage());
            e.printStackTrace();
           
        }
        return null;
    }
        
    
    
    @Override
    public Cuenta generarRetiro(Cuenta c) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
