package data;

import data.exceptions.MalformedPrescriptionCodeException;

final public class ePrescripCode {
    private final String code;

    public ePrescripCode(String code) throws IllegalArgumentException, MalformedPrescriptionCodeException{
        if (code == null)
            throw new IllegalArgumentException("Null not allowed as prescription code.");
        if (!code.matches("^[0-9]+$") || code.length() != 10)
            throw new MalformedPrescriptionCodeException("Code contains characters other than numbers.");
        this.code= code;
    }

    public String getCode(){
        return this.code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ePrescripCode prescripCode = (ePrescripCode) o;
        return this.code.equals(prescripCode.code);
    }

    @Override
    public int hashCode() {
        return this.code.hashCode();
    }

    @Override
    public String toString() {
        return "ePrescripCode{" + "prescription code=" + this.code + '\'' + '}';
    }

}
