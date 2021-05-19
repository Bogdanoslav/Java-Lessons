package block_13_ORM.exceptions;

public class DBConnectionError extends Error {

    public DBConnectionError(String message, Throwable e) {
        super(message, e);
    }
}
