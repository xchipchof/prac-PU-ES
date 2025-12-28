package dobles;


import data.HealthCardID;
import medicalconsultation.MedicalHistory;
import medicalconsultation.MedicalPrescription;
import services.exceptions.AnyCurrentPrescriptionException;
import services.exceptions.AnyCurrentPrescriptionException;

public class NoPrescriptionHealthNationalServiceMock extends SuccessfulHealthNationalServiceMock {
    @Override
    public MedicalPrescription getMedicalPrescription(HealthCardID cip, String illness)
            throws AnyCurrentPrescriptionException {
        throw new AnyCurrentPrescriptionException("No se han encontrado prescripciones activas del paciente para esa enfermedad");
    }
    @Override
    public MedicalPrescription sendHistoryAndPrescription(HealthCardID cip, MedicalHistory hce, String illness, MedicalPrescription mPresc)
            throws AnyCurrentPrescriptionException {
        throw new AnyCurrentPrescriptionException("No se han encontrado prescripciones activas del paciente para esa enfermedad");
    }
}

