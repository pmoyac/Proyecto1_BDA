
package interfaces;

import excepciones.PersistenciaException;
import java.util.List;
import objetos.Cuenta;

/**
 *
 * @author Pedro Moya, Adriana Gutiérrez
 */
public interface ICuenta {
    
    Cuenta agregarCuenta(Cuenta c) throws PersistenciaException;
    
    Cuenta eliminaCuenta(int numero_cuenta) throws PersistenciaException;
    
    Cuenta transferir(int nc1, int nc2, float monto) throws PersistenciaException;
    
    Cuenta generarRetiro(int nc, float monto) throws PersistenciaException;
    
    List<Cuenta> buscarCuentas(int idCliente) throws PersistenciaException;
    
    
}
