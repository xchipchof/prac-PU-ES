package medicalconsultation;
import data.HealthCardID;
import medicalconsultation.MedicalHistory;
import medicalconsultation.exceptions.IncorrectParametersException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MedicalHistoryTest {
    HealthCardID hc = new HealthCardID("asediejscescorjs");
    MedicalHistory mh = new MedicalHistory(hc, 1);
    @Test
    public void testExceptions(){
        assertThrows(
                IncorrectParametersException.class,
                () -> new MedicalHistory(null, 1)

        );
        assertThrows(
                IncorrectParametersException.class,
                () -> new MedicalHistory(hc, 0)

        );
    }
    @Test
    public void testGetters(){
        assertEquals(hc.getPersonalID(), mh.getHealthCardID().getPersonalID());
        assertEquals(1, mh.getMembShipNumb());
        assertNull(mh.getHistory());
    }
    @Test
    public void addAnnotations(){
        mh.addMedicalHistoryAnnotations("No hay cambios significativos");
        assertEquals("No hay cambios significativos\n",mh.getHistory());
    }
    @Test
    public void changeDoctor(){
        mh.setNewDoctor(2);
        assertEquals(2, mh.getMembShipNumb());
    }
}
