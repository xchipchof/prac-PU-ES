package data;
import data.exceptions.NotAlphanumericFormatException;

final public class HealthCardID {
    private final String personalID;

    public HealthCardID(String code) throws IllegalArgumentException {
        if (code == null)
                throw new IllegalArgumentException("No nulls allowed as HealthCardID codes.");
        else if (!code.matches("^[A-Za-z0-9]+$"))
            throw new NotAlphanumericFormatException("Code contains digits that are not allowed as the HealthCardID format defined.");
        else if (code.length() != 16)
            throw new IllegalArgumentException("Code length is not of 16 valid digits.");
        this.personalID = code;
    }

    public String getPersonalID() {
        return personalID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HealthCardID hcardID = (HealthCardID) o;
        return personalID.equals(hcardID.personalID);
    }

    @Override
    public int hashCode() {
        return personalID.hashCode();
    }

    @Override
    public String toString() {
        return "HealthCardID{" + "personal code=" + personalID + '\'' + '}';
    }
}
