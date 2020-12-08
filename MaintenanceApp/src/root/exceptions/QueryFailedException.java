package root.exceptions;

public class QueryFailedException extends RuntimeException {

    /**
     * Creates a new instance of <code>QueryFailedException</code> without
     * detail message.
     */
    public QueryFailedException() {
    }

    /**
     * Constructs an instance of <code>QueryFailedException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public QueryFailedException(String msg) {
        super(msg);
    }
}
