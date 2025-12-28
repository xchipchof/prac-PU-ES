package dobles;

import data.HealthCardID;
import medicalconsultation.MedicalHistory;
import medicalconsultation.MedicalPrescription;

import java.net.ConnectException;

public class ConnectionErrorHealthNationalServiceMock extends SuccessfulHealthNationalServiceMock{
    @Override
    public MedicalHistory getMedicalHistory(HealthCardID cip) throws ConnectException{
        throw new ConnectException("Connection failure with SNS");
    }
    @Override
    public MedicalPrescription getMedicalPrescription(HealthCardID cip, String illness) throws  ConnectException{
        throw new ConnectException("Connection failure with SNS");
    }
    @Override
    public MedicalPrescription sendHistoryAndPrescription(HealthCardID cip, MedicalHistory hce, String illness, MedicalPrescription mPresc) throws ConnectException{
        throw new ConnectException("Connection failure with SNS");
    }
    @Override
    public MedicalPrescription generateTreatmCodeAndRegister(MedicalPrescription ePresc) throws ConnectException{
        throw new ConnectException("Connection failure with SNS");
    }
}
