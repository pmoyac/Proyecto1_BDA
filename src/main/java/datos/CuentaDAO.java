package datos;

import excepciones.PersistenciaException;
import interfaces.IConexion;
import interfaces.ICuenta;
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
    public Cuenta transferir(Cuenta c1, Cuenta c2) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Cuenta generarRetiro(Cuenta c) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
