package root.exceptions;

public class InvalidIndexException extends RuntimeException {

    /**
     * Creates a new instance of <code>InvalidIndex</code> without detail
     * message.
     */
    public InvalidIndexException() {
    }

    /**
     * Constructs an instance of <code>InvalidIndex</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public InvalidIndexException(String msg) {
        super(msg);
    }
}
