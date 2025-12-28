package dobles;

import data.HealthCardID;
import medicalconsultation.MedicalHistory;
import medicalconsultation.MedicalPrescription;
import services.HealthNationalService;
import services.exceptions.AnyCurrentPrescriptionException;
import services.exceptions.HealthCardIDException;
import services.exceptions.NotCompleteMedicalPrescription;

import java.net.ConnectException;

public class SuccessfulHealthNationalServiceMock implements HealthNationalService {


    @Override
    public MedicalHistory getMedicalHistory(HealthCardID cip)
            throws ConnectException, HealthCardIDException {
        try {
            return TestDataProvider.generaHistorialBuit();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public MedicalPrescription getMedicalPrescription(HealthCardID cip, String illness)
            throws ConnectException, HealthCardIDException, AnyCurrentPrescriptionException {
        try {
            return TestDataProvider.generaPrescripcioVigent();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public MedicalPrescription sendHistoryAndPrescription(HealthCardID cip, MedicalHistory hce, String illness, MedicalPrescription mPresc)
            throws ConnectException, HealthCardIDException, AnyCurrentPrescriptionException, NotCompleteMedicalPrescription {
        return mPresc;
    }

    @Override
    public MedicalPrescription generateTreatmCodeAndRegister(MedicalPrescription ePresc)
            throws ConnectException {
        return ePresc;
    }
}
