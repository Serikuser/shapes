package by.siarhei.shapes.exception;

public class NotValidDataInLineException extends Exception {

    public NotValidDataInLineException(String message) {
        super(message);

    }

    public NotValidDataInLineException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotValidDataInLineException(Throwable cause) {
        super(cause);
    }

    public NotValidDataInLineException() {
    }
}
