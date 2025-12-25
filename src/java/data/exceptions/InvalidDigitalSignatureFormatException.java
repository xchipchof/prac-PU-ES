package data.exceptions;

public class InvalidDigitalSignatureFormatException extends RuntimeException {
    public InvalidDigitalSignatureFormatException(String message) {
        super(message);
    }
}
