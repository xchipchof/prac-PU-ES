package data;

import data.ePrescripCode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ePrescripCodeTest {

    @Test
    public void checkConstructor(){
        ePrescripCode codiPrescripcio = new ePrescripCode("294914009");

        assertEquals("294914009", codiPrescripcio.getCode());
    }


    @Test
    public void codiNoNumeric(){
        String codiLleig = "dbashj281sajhdb";
        assertThrows(IllegalArgumentException.class,
                () -> new ePrescripCode(codiLleig)
        );
    }

    @Test
    public void codiNullTest(){
        assertThrows(
                IllegalArgumentException.class,
                () -> new ePrescripCode(null)
        );
    }

}
