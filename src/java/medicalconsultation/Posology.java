package medicalconsultation;

import data.ProductID;

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
    public void setFreq(float freq, FqUnit freqUnit){
        this.freq = freq;
        this.freqUnit = freqUnit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Posology posology = (Posology) o;
        return this.dose == posology.dose && this.freq == posology.freq && this.freqUnit == posology.freqUnit;
    }
}