package services;

import data.HealthCardID;

import java.net.ConnectException;

public interface HealthNationalService {
    MedicalHistory getMedicalHistory(HealthCardID cip) 
            throws ConnectException, HealthCardIDException;
    
    MedicalPrescription getMedicalPrescription(HealthCardID cip, String illness) 
            throws ConnectException, HealthCardIDException, AnyCurrentPrescriptionException;
    
    MedicalPrescription sendHistoryAndPrescription(HealthCardID cip, History hce, String  illness, MedicalPrescription mPresc) 
            throws ConnectException, HealthCardIDException,AnyCurrentPrescriptionException, NotCompleteMedicalPrescription;
    
    MedicalPrescription generateTreatmCodeAndRegister(MedicalPrescription ePresc) 
            throws ConnectException;
}
