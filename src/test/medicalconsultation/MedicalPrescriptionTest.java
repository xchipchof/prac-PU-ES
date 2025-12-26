package medicalconsultation;

import data.*;
import medicalconsultation.exceptions.IncorrectTakingGuidelinesException;
import medicalconsultation.exceptions.ProductAlreadyInPrescriptionException;
import medicalconsultation.exceptions.ProductNotInPrescriptionException;
import org.junit.jupiter.api.Test;

import java.security.SecureRandom;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class MedicalPrescriptionTest {
    HealthCardID hc = new HealthCardID("qwertyuiiuyhnjhb");
    ePrescripCode pc = new ePrescripCode("1234567890");
    Date endDate = new Date(2026, 1, 20);
    MedicalPrescription mp = new MedicalPrescription(hc, 1, "resfriado", pc, endDate);
    String[] instruc = {"BEFOREBREAKFAST", "30", "1", "1", "DAY", "No tomar alcohol"};
    @Test
    public void testExceptions(){
        mp.addLine(new ProductID("000000000001"), instruc);
        assertThrows(
                ProductAlreadyInPrescriptionException.class,
                () -> mp.addLine(new ProductID("000000000001"), instruc)

        );
        String[] instruc2 = {"BEFOREBREAKFAST", "30", "1", "1", "DAY", "No tomar alcohol", "patata"};
        assertThrows(
                IncorrectTakingGuidelinesException.class,
                () -> mp.addLine(new ProductID("000000000002"), instruc2)

        );
        String[] instruc3 = {"BREAKFASTBEFORE", "30", "1", "1", "DAY", "No tomar alcohol"};
        assertThrows(
                IncorrectTakingGuidelinesException.class,
                () -> mp.addLine(new ProductID("000000000002"), instruc3)

        );
        assertThrows(
                ProductNotInPrescriptionException.class,
                () -> mp.modifyDoseInLine(new ProductID("000000000003"), 2)

        );
        assertThrows(
                ProductNotInPrescriptionException.class,
                () -> mp.removeLine(new ProductID("000000000003"))

        );
    }
    @Test
    public void testGetters(){
        mp.addLine(new ProductID("000000000001"), instruc);
        TakingGuideline tg = mp.getTakingGuideline(new ProductID("000000000001"));
        assertEquals(new TakingGuideline(dayMoment.BEFOREBREAKFAST,30,1,1,FqUnit.DAY,"No tomar alcohol"), tg);
        assertEquals(1, mp.getMembShipNumb());
        assertEquals(pc, mp.getPrescCode());
        assertEquals(endDate, mp.getEndDate());
        assertNotNull(mp.getPrescDate());
        assertEquals("resfriado", mp.getIllness());
        assertEquals(hc, mp.getCip());
    }
    @Test
    public void testSetters(){
        mp.setPrescDateAndEndDate(new Date(2026, 1, 25));
        assertEquals(new Date(2026, 1, 25), mp.getEndDate());
        byte[] randomBytes = new byte[64];
        new SecureRandom().nextBytes(randomBytes);
        mp.seteSign(new DigitalSignature(randomBytes));
        assertEquals(new DigitalSignature(randomBytes), mp.geteSign());
    }
}
