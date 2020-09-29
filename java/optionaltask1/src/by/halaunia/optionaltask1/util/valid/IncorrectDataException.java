package by.halaunia.optionaltask1.util.valid;

public class IncorrectDataException extends Exception {

    public IncorrectDataException(String message) {
        super(message);
    }

    public IncorrectDataException(Exception cause) {
        super(cause);
    }

    public IncorrectDataException(String message, Exception cause) {
        super(message, cause);
    }
}
