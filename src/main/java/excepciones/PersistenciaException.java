package excepciones;

/**
 *
 * @author Pedro Moya, Adriana Gutiérrez
 */
public class PersistenciaException extends Exception{
    
    public PersistenciaException(){}
    
    public PersistenciaException(String mensaje){
        super(mensaje);
    }
    
    public PersistenciaException(Throwable t){
        super(t);
    }

    public PersistenciaException(String mensaje, Throwable causa, boolean sup, boolean stackTrace){
        super(mensaje, causa, sup, stackTrace);
    }
    
}
