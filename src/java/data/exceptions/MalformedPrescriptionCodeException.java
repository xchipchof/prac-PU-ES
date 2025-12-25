package data.exceptions;

public class MalformedPrescriptionCodeException extends RuntimeException {
    public MalformedPrescriptionCodeException(String message) {
        super(message);
    }
}
