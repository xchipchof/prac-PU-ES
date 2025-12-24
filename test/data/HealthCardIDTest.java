package data;

import data.HealthCardID;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HealthCardIDTest {

    private HealthCardID cip;

    @Test
    public void arribaNullAlConstructorTest(){

        assertThrows(
                IllegalArgumentException.class,
                () -> new HealthCardID(null)

        );

    }
    @Test
    public void arribaNoAlfanumericAlConstructorTest(){

        assertThrows(
                IllegalArgumentException.class,
                () -> new HealthCardID("\uD83D\uDE0B")
        );

    }
    @Test
    public void arribaFormatIncorrecteAlConstructorTest(){

        assertThrows(
                IllegalArgumentException.class,
                () -> new HealthCardID("A32B4")
        );

    }
    
}
