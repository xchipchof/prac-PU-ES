package consultationTerminal;

import data.*;
import data.exceptions.*;
import medicalconsultation.*;
import medicalconsultation.exceptions.*;
import consultationTerminal.exceptions.*;
import services.*;
import services.exceptions.*;
import services.suggestions.*;

import java.net.ConnectException;
import java.util.Date;
import java.util.List;

public class ConsultationTerminal {

    private HealthNationalService hns;
    private DecisionMakingAI ai;

    private MedicalHistory currentHistory;
    private MedicalPrescription currentPrescription;
    private boolean isRevisionActive = false;
    private boolean isEditing = false;

    public void setHealthNationalService(HealthNationalService hns) {
        this.hns = hns;
    }

    public void setDecisionMakingAI(DecisionMakingAI ai) {
        this.ai = ai;
    }

    public void initRevision(HealthCardID cip, String illness)
            throws ConnectException, HealthCardIDException, AnyCurrentPrescriptionException{

        this.currentHistory = hns.getMedicalHistory(cip);
        this.currentPrescription = hns.getMedicalPrescription(cip, illness);

        this.isRevisionActive = true;
        this.isEditing = false;
    }

    public String getSuggestions(String prompt) throws BadPromptException, ProceduralException {

        if (!isRevisionActive || currentPrescription == null) {
            throw new ProceduralException("Error procedural: No hay una revisión o prescripción activa.");
        }

        return ai.getSuggestions(prompt);
    }

    public List<Suggestion> parseSuggest(String aiAnswer)
            throws ProceduralException, NonUPCFormatException {
        if (!isRevisionActive) {
            throw new ProceduralException("Error procedural: No se puede parsear sin una revisión activa.");
        }
        return ai.parseSuggest(aiAnswer);
    }


    public void enterMedicineWithGuidelines(ProductID prodID, String[] instruc)
            throws ProductAlreadyInPrescriptionException, IncorrectTakingGuidelinesException, ProceduralException {

        checkEditionState();
        currentPrescription.addLine(prodID, instruc);
    }

    public void modifyDoseInLine(ProductID prodID, float newDose)
            throws ProductNotInPrescriptionException, ProceduralException {

        checkEditionState();
        currentPrescription.modifyDoseInLine(prodID, newDose);
    }

    public void removeLine(ProductID prodID)
            throws ProductNotInPrescriptionException, NonUPCFormatException, ProceduralException {

        checkEditionState();
        currentPrescription.removeLine(prodID);
    }

    public void enterTreatmentEndingDate(Date date)
            throws IncorrectEndingDateException, ProceduralException {
        if (!isRevisionActive) throw new ProceduralException("Sesión inactiva");

        if (date.before(new Date())) {
            throw new IncorrectEndingDateException("La fecha de fin debe ser posterior a hoy");
        }
        currentPrescription.setPrescDateAndEndDate(date);
    }

    public void enterMedicalAssessmentInHistory(String assess) {
        if (currentHistory != null) {
            currentHistory.addMedicalHistoryAnnotations(assess);
        }
    }

    private void checkEditionState() throws ProceduralException {
        if (!isRevisionActive || !isEditing || currentPrescription == null) {
            throw new ProceduralException("La edición de la prescripción no ha sido iniciada.");
        }
    }

}