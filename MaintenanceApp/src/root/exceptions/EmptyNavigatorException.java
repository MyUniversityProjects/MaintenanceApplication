package root.exceptions;


public class EmptyNavigatorException extends RuntimeException {

    /**
     * Creates a new instance of EmptyNavigatorException without
     * detail message.
     */
    public EmptyNavigatorException() {
    }

    /**
     * Constructs an instance of EmptyNavigatorException with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public EmptyNavigatorException(String msg) {
        super(msg);
    }
}
