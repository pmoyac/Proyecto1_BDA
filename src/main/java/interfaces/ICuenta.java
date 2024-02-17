
package interfaces;

import excepciones.PersistenciaException;
import objetos.Cuenta;

/**
 *
 * @author Pedro Moya, Adriana Gutiérrez
 */
public interface ICuenta {
    
    Cuenta agregarCuenta(Cuenta c) throws PersistenciaException;
    
    Cuenta eliminaCuenta(int numero_cuenta) throws PersistenciaException;
    
    Cuenta transferir(int nc1, int nc2, float monto) throws PersistenciaException;
    
    Cuenta generarRetiro(Cuenta c) throws PersistenciaException;
}
