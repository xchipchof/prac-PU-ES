package dobles;

import data.HealthCardID;
import medicalconsultation.MedicalHistory;
import medicalconsultation.MedicalPrescription;
import services.exceptions.HealthCardIDException;

public class InvalidCIPHealthNationalServiceMock extends SuccessfulHealthNationalServiceMock {
    @Override
    public MedicalHistory getMedicalHistory(HealthCardID cip) throws HealthCardIDException {
        throw new HealthCardIDException("CIP no registrado en el SNS.");
    }
    @Override
    public MedicalPrescription getMedicalPrescription(HealthCardID cip, String illness) throws  HealthCardIDException{
        throw new HealthCardIDException("CIP no registrado en el SNS.");
    }
    @Override
    public MedicalPrescription sendHistoryAndPrescription(HealthCardID cip, MedicalHistory hce, String illness, MedicalPrescription mPresc) throws HealthCardIDException{
        throw new HealthCardIDException("CIP no registrado en el SNS.");
    }
}
