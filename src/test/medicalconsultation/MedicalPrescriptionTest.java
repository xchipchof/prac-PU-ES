package medicalconsultation;

import data.*;
import medicalconsultation.exceptions.IncorrectTakingGuidelinesException;
import medicalconsultation.exceptions.ProductAlreadyInPrescriptionException;
import medicalconsultation.exceptions.ProductNotInPrescriptionException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.SecureRandom;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class MedicalPrescriptionTest {
    HealthCardID hc;
    ePrescripCode pc;
    Date endDate;
    MedicalPrescription mp;
    String[] instruc;
    ProductID prod1;

    @BeforeEach
    void initTest() throws Exception {
        hc = new HealthCardID("qwertyuiiuyhnjhb");
        pc = new ePrescripCode("1234567890");
        endDate = new Date(2026, 1, 20);
        mp = new MedicalPrescription(hc, 1, "resfriado", pc, endDate);
        instruc = new String[]{"BEFOREBREAKFAST", "30", "1", "1", "DAY", "No tomar alcohol"};

        prod1 = new ProductID("000000000001");
    }

    @Test
    public void testExceptions() throws Exception {
        ProductID prod2 = new ProductID("000000000002");
        ProductID prod3 = new ProductID("000000000003");
        mp.addLine(prod1, instruc);
        assertThrows(
                ProductAlreadyInPrescriptionException.class,
                () -> mp.addLine(prod1, instruc)

        );
        String[] instruc2 = {"BEFOREBREAKFAST", "30", "1", "1", "DAY", "No tomar alcohol", "patata"};
        assertThrows(
                IncorrectTakingGuidelinesException.class,
                () -> mp.addLine(prod2, instruc2)

        );
        String[] instruc3 = {"BREAKFASTBEFORE", "30", "1", "1", "DAY", "No tomar alcohol"};
        assertThrows(
                IncorrectTakingGuidelinesException.class,
                () -> mp.addLine(prod2, instruc3)

        );
        assertThrows(
                ProductNotInPrescriptionException.class,
                () -> mp.modifyDoseInLine(prod3, 2)

        );
        assertThrows(
                ProductNotInPrescriptionException.class,
                () -> mp.removeLine(prod3)

        );
    }

    @Test
    public void testGetters() {
        mp.addLine(prod1, instruc);
        TakingGuideline tg = mp.getTakingGuideline(prod1);
        assertEquals(new TakingGuideline(dayMoment.BEFOREBREAKFAST, 30, 1, 1, FqUnit.DAY, "No tomar alcohol"), tg);
        assertEquals(1, mp.getMembShipNumb());
        assertEquals(pc, mp.getPrescCode());
        assertEquals(endDate, mp.getEndDate());
        assertNotNull(mp.getPrescDate());
        assertEquals("resfriado", mp.getIllness());
        assertEquals(hc, mp.getCip());
    }

    @Test
    public void testSetters() throws Exception{
        mp.setPrescDateAndEndDate(new Date(2026, 1, 25));
        assertEquals(new Date(2026, 1, 25), mp.getEndDate());
        byte[] randomBytes = new byte[64];
        new SecureRandom().nextBytes(randomBytes);
        mp.seteSign(new DigitalSignature(randomBytes));
        assertEquals(new DigitalSignature(randomBytes), mp.geteSign());
    }
}
