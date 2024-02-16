package interfaces;

import excepciones.PersistenciaException;
import objetos.Cliente;

/**
 *
 * @author Pedro Moya, Adriana Gutiérrez 
 */
public interface ICliente {
    
    Cliente registrarCliente(Cliente c) throws PersistenciaException;
        
    Cliente actualizarCliente(Cliente c) throws PersistenciaException;
    
    Cliente buscarCliente(int id) throws PersistenciaException;
    
    
}
