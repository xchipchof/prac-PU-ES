package medicalconsultation;

public class TakingGuideline { // Represents the taking guidelines for a medicine

    private dayMoment dMoment;

    private float duration;

    private Posology posology;

    private String instructions;

    public TakingGuideline(dayMoment dM, float du, float d, float f, FqUnit fu, String i) { // Initializes attributes
        if(dM == null) {
            throw new IllegalArgumentException("Debe seleccionarse el/los momentos del dia para tomar el medicamento");
        }
        if(du <= 0) {
            throw new IllegalArgumentException("La duracion tiene que ser positiva");
        }
        this.dMoment = dM;
        this.duration =du;
        this.posology = new Posology(d, f, fu);
        this.instructions = i;
    }
    // the getters and setters
    public dayMoment getDayMoment(){
        return this.dMoment;
    }
    public float getDuration(){
        return this.duration;
    }
    public Posology getPosology(){
        return this.posology;
    }
    public String getInstructions(){
        return this.instructions;
    }

    public void setDayMoment(dayMoment dMoment){
        this.dMoment = dMoment;
    }
    public void setDuration(float duration){
        this.duration = duration;
    }
    public void setInstructions(String instructions){
        this.instructions = instructions;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TakingGuideline takingGuideline = (TakingGuideline) o;
        return this.dMoment == takingGuideline.dMoment && this.posology.equals(takingGuideline.posology) && this.instructions == takingGuideline.instructions;
    }
}