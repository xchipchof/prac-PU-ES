package data;

import data.exceptions.NonUPCFormatException;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductIDTest {

    @Test
    public void checkConstructor(){
        ProductID idProducte = new ProductID("979543956330");

        assertEquals("979543956330", idProducte.getUPC());
    }

    @Test
    public void noCompleixFormatUPCTest(){
        String codiLleig = "1234ABC";
        assertThrows(
                NonUPCFormatException.class,
                () -> new ProductID(codiLleig)
        ); 
        }

    @Test
    public void llargadaIncorrectaDelCodiTest(){
        String codiCurt = "1495038";
        assertThrows(NonUPCFormatException.class,
                () -> new ProductID(codiCurt)
        );
    }

    @Test
    public void codiNullTest(){
        assertThrows(
                IllegalArgumentException.class,
                () -> new ProductID(null)
        );
    }

}
