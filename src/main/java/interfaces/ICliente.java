package interfaces;

import DTOs.ClienteDTO;
import excepciones.PersistenciaException;
import objetos.Cliente;

/**
 * @author Pedro Moya, Adriana Gutiérrez 
 */
public interface ICliente {
    
    Cliente registrarCliente(ClienteDTO clienteDTO) throws PersistenciaException;
        
    Cliente actualizarCliente(ClienteDTO clienteDTO) throws PersistenciaException;
    
    Cliente buscarCliente(String usuario, String contrasena) throws PersistenciaException;
    
    
}
