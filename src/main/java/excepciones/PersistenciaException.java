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
  
    public PersistenciaException(String message, Throwable cause) {
        super(message, cause);
    }

    public PersistenciaException(Throwable cause) {
        super(cause);
    }

    public PersistenciaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
