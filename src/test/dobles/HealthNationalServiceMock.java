package dobles;

import data.HealthCardID;
import medicalconsultation.MedicalHistory;
import medicalconsultation.MedicalPrescription;
import services.HealthNationalService;
import services.exceptions.AnyCurrentPrescriptionException;
import services.exceptions.HealthCardIDException;
import services.exceptions.NotCompleteMedicalPrescription;

import java.net.ConnectException;

public class HealthNationalServiceMock implements HealthNationalService {


    @Override
    public MedicalHistory getMedicalHistory(HealthCardID cip)
            throws ConnectException, HealthCardIDException {
        return null;
    }

    @Override
    public MedicalPrescription getMedicalPrescription(HealthCardID cip, String illness)
            throws ConnectException, HealthCardIDException, AnyCurrentPrescriptionException {
        return null;
    }

    @Override
    public MedicalPrescription sendHistoryAndPrescription(HealthCardID cip, MedicalHistory hce, String illness, MedicalPrescription mPresc)
            throws ConnectException, HealthCardIDException, AnyCurrentPrescriptionException, NotCompleteMedicalPrescription {
        return null;
    }

    @Override
    public MedicalPrescription generateTreatmCodeAndRegister(MedicalPrescription ePresc)
            throws ConnectException {
        return null;
    }
}
