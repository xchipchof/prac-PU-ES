package medicalconsultation;

public class Posology { // A class that represents the posology of a medicine

    private float dose;

    private float freq;

    private FqUnit freqUnit;

    public Posology (float d, float f, FqUnit u) { 
        if (d <=0) {
         throw new IllegalArgumentException("La dosis debe ser mayor que 0");
        }
        if (f <=0) {
         throw new IllegalArgumentException("La frecuencia debe ser positiva");
        }
        if (u == null) {
         throw new IllegalArgumentException("La unidad de frecuencia no puede ser nula");
        }
        this.dose = d;
        this.freq = f;
        this.freqUnit = u;
     } // Initializes attributes
    
     // the getters and setters
    public float getDose(){
       return this.dose;
    }
    public float getFreq(){
       return this.freq;
    }
    public FqUnit getFreqUnit(){
       return this.freqUnit;
    }
    public void setDose(float dose){
      this.dose = dose;
    }
}