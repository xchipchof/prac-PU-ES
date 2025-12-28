package services.suggestions;

import data.ProductID;

public class InsertionSuggestion extends Suggestion {
    private final float dose;
    private final float freq;
    private final String freqUnit;
    private final float duration;
    private final String dayMoment;
    private final String instructions;

    public InsertionSuggestion(ProductID item, float dose, float freq, String freqUnit,
                               float duration, String dayMoment, String instructions) {
        super(item, "I");
        this.dose = dose;
        this.freq = freq;
        this.freqUnit = freqUnit;
        this.duration = duration;
        this.dayMoment = dayMoment;
        this.instructions = instructions;
    }

    // Getters
    public float getDose() { return dose; }
    public float getFreq() { return freq; }
    public String getFreqUnit() { return freqUnit; }
    public float getDuration() { return duration; }
    public String getDayMoment() { return dayMoment; }
    public String getInstructions() { return instructions; }
}