package medicalconsultation;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TakingGidelineTest {
    TakingGuideline t = new TakingGuideline(dayMoment.AFTERLUNCH, 30, 2, 10, FqUnit.HOUR, "No combinar con alcohol");
    @Test
    public void testExceptions() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new TakingGuideline(null, 30, 2, 10, FqUnit.HOUR, "No combinar con alcohol")
        );
        assertThrows(
                IllegalArgumentException.class,
                () -> new TakingGuideline(dayMoment.AFTERLUNCH, 0, 2, 10, FqUnit.HOUR, "No combinar con alcohol")

        );
    }
    @Test
    public void testGetters(){
        assertEquals(dayMoment.AFTERLUNCH, t.getDayMoment());
        assertEquals(30, t.getDuration());
        assertEquals("No combinar con alcohol", t.getInstructions());
        Posology p = t.getPosology();
        assertEquals(new Posology(2, 10, FqUnit.HOUR), p);
    }
    @Test
    public void testSetters(){
        t.setDayMoment(dayMoment.BEFOEMEALS);
        t.setDuration(10);
        t.setInstructions("No combinar con lacteos");
        assertEquals(dayMoment.BEFOEMEALS, t.getDayMoment());
        assertEquals(10, t.getDuration());
        assertEquals("No combinar con lacteos", t.getInstructions());
    }
}
