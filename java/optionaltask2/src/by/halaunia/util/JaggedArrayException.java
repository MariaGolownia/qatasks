package by.halaunia.util;

public class JaggedArrayException extends Exception {

    public JaggedArrayException(String message) {
        super(message);
    }

    public JaggedArrayException(Exception cause) {
        super(cause);
    }

    public JaggedArrayException(String message, Exception cause) {
        super(message, cause);
    }
}
