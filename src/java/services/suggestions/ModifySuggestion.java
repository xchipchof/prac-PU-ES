package services.suggestions;

import data.ProductID;

public class ModifySuggestion extends Suggestion {
    private final Float dose;
    private final Float freq;
    private final String freqUnit;
    private final Float duration;
    private final String dayMoment;
    private final String instructions;
    public ModifySuggestion(ProductID item, Float dose, Float freq, String freqUnit,
                            Float duration, String dayMoment, String instructions) {
        super(item, "M");
        this.dose = dose;
        this.freq = freq;
        this.freqUnit = freqUnit;
        this.duration = duration;
        this.dayMoment = dayMoment;
        this.instructions = instructions;
    }
    public Float getDose() { return dose; }
    public Float getFreq() { return freq; }
    public String getFreqUnit() { return freqUnit; }
    public Float getDuration() { return duration; }
    public String getDayMoment() { return dayMoment; }
    public String getInstructions() { return instructions; }
}