package root.exceptions;

public class NotFoundException extends Exception {

    /**
     * Creates a new instance of NotFoundException without detail
     * message.
     */
    public NotFoundException() {
    }

    /**
     * Constructs an instance of NotFoundException with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public NotFoundException(String msg) {
        super(msg);
    }
}
