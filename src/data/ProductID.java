package data;
import data.exceptions.NonUPCFormatException;

public final class ProductID {


    private final String universalProductCode;

    public ProductID(String code) throws IllegalArgumentException,NonUPCFormatException{
        if (code == null)
            throw new IllegalArgumentException("Code cannot be null");
        if (code.length() != 12 || code.matches(""))
            throw new NonUPCFormatException("Code is not fully composed of digits or it is not 12 digits long.");

        this.universalProductCode = code;
    }

    public String getUPC() {
        return this.universalProductCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductID productID = (ProductID) o;
        return this.universalProductCode.equals(productID.universalProductCode);
    }

    @Override
    public int hashCode() {
        return this.universalProductCode.hashCode();
    }

    @Override
    public String toString() {
        return "ProductID{" + "UPC=" + this.universalProductCode + '\'' + '}';
    }


}
