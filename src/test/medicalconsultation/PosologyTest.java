package medicalconsultation;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PosologyTest {
    Posology p = new Posology(2, 10, FqUnit.HOUR);
    @Test
    public void testExceptions(){
        assertThrows(
                IllegalArgumentException.class,
                () -> new Posology(0, 10, FqUnit.HOUR)

        );
        assertThrows(
                IllegalArgumentException.class,
                () -> new Posology(2, -10, FqUnit.HOUR)

        );
        assertThrows(
                IllegalArgumentException.class,
                () -> new Posology(2, 10, null)

        );
    }
    @Test
    public void testGetters(){
        assertEquals(2, p.getDose());
        assertEquals(10, p.getFreq());
        assertEquals(FqUnit.HOUR, p.getFreqUnit());
    }
    @Test
    public void changeDose(){
        p.setDose(5);
        assertEquals(5, p.getDose());
    }
    @Test
    public void changeFreq(){
        p.setFreq(1, FqUnit.DAY);
        assertEquals(1, p.getFreq());
        assertEquals(FqUnit.DAY, p.getFreqUnit());
    }
}
