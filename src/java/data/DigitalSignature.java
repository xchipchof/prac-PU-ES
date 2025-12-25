package data;

import data.exceptions.InvalidDigitalSignatureFormatException;

import java.util.Arrays;

final public class DigitalSignature {
    private final byte[] signature;

    public DigitalSignature(byte[] signatura){
        if (signatura == null)
            throw new IllegalArgumentException("DigitalSignature cannot be instantiated with null");
        if (signatura.length != 64)
            throw new InvalidDigitalSignatureFormatException("DigitalSignature format is of 64 bytes.");

        this.signature = signatura.clone();

    }

    public byte[] getSignature() {
        return signature.clone();
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DigitalSignature signa = (DigitalSignature) o;

        return Arrays.equals(this.signature, signa.signature);

    }

    @Override
    public int hashCode(){
        return Arrays.hashCode(this.signature);
    }

    @Override
    public String toString(){
        return "DigitalSignature{" +
                "signature= " +
                Arrays.toString(signature) +
                " }";

    }
}
