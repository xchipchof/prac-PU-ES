package services.exceptions;

public class NotCompleteMedicalPrescription extends RuntimeException {
    public NotCompleteMedicalPrescription(String message) {
        super(message);
    }
}
