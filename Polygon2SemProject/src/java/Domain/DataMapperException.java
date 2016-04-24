
package Domain;

/**
 *
 * @author Henrik
 */

public class DataMapperException extends Exception {

    public DataMapperException() {
       
    }

    public DataMapperException(String message) {
        super(message);
    
    }

    public DataMapperException(Throwable cause) {
        super(cause);
 
    }

    public DataMapperException(String message, Throwable cause) {
        super(message, cause);

    }

}