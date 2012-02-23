package mike.utils.jsimpletext.exceptions;

/**
 * SimpleTextException.java
 * Created on 19/02/2012, 18:52:44
 * 
 * @author Miguel Augusto Caligares
 * @email mcaligares@gmail.com
 * @version 0.1
 */
public class SimpleTextException extends Exception{
    private static final long serialVersionUID = 4541468570324105432L;

    public SimpleTextException(Throwable cause) {
        super(cause);
    }

    public SimpleTextException(String message, Throwable cause) {
        super(message, cause);
    }
    // show a message with field that failured.
    public SimpleTextException(String message) {
        super(message);
    }

    public SimpleTextException() {
    }
}
