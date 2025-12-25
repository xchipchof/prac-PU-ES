package medicalconsultation;

import data.HealthCardID;

/**
 * Package for the classes involved in the use case Supervise treatment
 */
public class MedicalHistory {// A class that represents a medical history

    private HealthCardID cip; // the CIP of the patient

    private int membShipNumb; // the membership number of the family doctor

    private String history; // the diverse annotations in the patient’s HCE

    public MedicalHistory (HealthCardID cip, int memberShipNum) throws IncorrectParametersException {
        if (cip == null) {
            throw new IncorrectParametersException("El CIP no puede ser nulo.");
        }
        if (memberShipNum <= 0) {
            throw new IncorrectParametersException("El número de colegiado no es válido.");
        }
        this.cip = cip;
        this.membShipNumb = memberShipNum;
        this.history = null;
    }

    // Makes its inicialization
    public void addMedicalHistoryAnnotations (String annot) {
        this.history += annot + "\n";
    }

    // Adds new annotations to the patient history
    public void setNewDoctor (int mshN)  { // Modifies the family doctor for patient
        this.membShipNumb = mshN;
    }
     // the getters
    public HealthCardID getHealthCardID(){
        return this.cip;
    }
    public int getMembShipNumb(){
        return this.membShipNumb;
    }
    public String getHistory(){
        return this.history;
    }
}
