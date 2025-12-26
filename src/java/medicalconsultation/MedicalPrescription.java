package medicalconsultation;

import data.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import medicalconsultation.exceptions.*;
public class MedicalPrescription {// A class that represents medical prescription

    private HealthCardID cip; // the healthcard ID of the patient

    private int membShipNumb; // the membership number of the family doctor

    private String illness; // illness associated

    private ePrescripCode prescCode; // the prescription code

    private Date prescDate; // the current date

    private Date endDate; // the date when the new treatment ends

    private DigitalSignature eSign; // the eSignature of the doctor
    
    private Map<ProductID,TakingGuideline> prescriptions;

    // Its components, that is, the set of medical prescription lines
    public MedicalPrescription (HealthCardID cip, int mSN, String i, ePrescripCode pC, Date eD) {
        this.cip = cip;
        this.membShipNumb = mSN;
        this.illness = i;
        this.prescCode = pC;
        this.prescDate = new Date();
        this.endDate = eD;
        this.eSign = null;
        this.prescriptions = new HashMap<>();
    } // Makes some inicialization

    public void addLine(ProductID prodID, String[] instruc)
            throws ProductAlreadyInPrescriptionException,
            IncorrectTakingGuidelinesException {
                if(this.prescriptions.containsKey(prodID)){
                        throw new ProductAlreadyInPrescriptionException("El producto ya esta recetado");
                }
                if(instruc.length != 6){
                    throw new IncorrectTakingGuidelinesException("Cantidad de instrucciones incorrecto");
                }
                try{
                    dayMoment dM = dayMoment.valueOf(instruc[0]);
                    float duration = Float.parseFloat(instruc[1]);
                    float dose = Float.parseFloat(instruc[2]);
                    float freq = Float.parseFloat(instruc[3]);
                    FqUnit freqUnit = FqUnit.valueOf(instruc[4]);
                    String instructions = instruc[5];
                    TakingGuideline takingGuideline = new TakingGuideline(dM, duration, dose, freq, freqUnit, instructions);
                    this.prescriptions.put(prodID, takingGuideline);
                    
                } catch (Exception e) {
                    throw new IncorrectTakingGuidelinesException("Formato de instrucciones incorrecto");
                }
            }

    public void modifyDoseInLine(ProductID prodID, float newDose)
            throws ProductNotInPrescriptionException {
                if(!this.prescriptions.containsKey(prodID)){
                        throw new ProductNotInPrescriptionException("El producto no esta recetado");
                }
                TakingGuideline receta = this.prescriptions.get(prodID);
                Posology posology = receta.getPosology();
                posology.setDose(newDose);
            }

    public void removeLine(ProductID prodID)
            throws ProductNotInPrescriptionException {
                if(!this.prescriptions.containsKey(prodID)){
                        throw new ProductNotInPrescriptionException("El producto no esta recetado");
                }
                this.prescriptions.remove(prodID);
            }

    public void setPrescDateAndEndDate(Date endDate) {
        this.endDate = endDate;
        this.prescDate = new Date();
    }
    
    public void seteSign(DigitalSignature eSign) {
        this.eSign = eSign;
    }

    public DigitalSignature geteSign() {
        return eSign;
    }
    public HealthCardID getCip() {
        return cip;
    }
    public int getMembShipNumb() {
        return membShipNumb;
    }
    public String getIllness() {
        return illness;
    }
    public ePrescripCode getPrescCode() {
        return prescCode;
    }
    public Date getPrescDate() {
        return prescDate;
    }    
    public Date getEndDate() {
        return endDate;
    }
    public  TakingGuideline getTakingGuideline(ProductID prodID) {
        return this.prescriptions.get(prodID);
    }
}
