package data;


import data.exceptions.InvalidDigitalSignatureFormatException;

import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

public class DigitalSignatureTest {

    @Test
    public void nullAlContructorTest() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new DigitalSignature(null)
        );
    }

    @Test
    public void arrayInmutableTest() throws Exception {
        byte[] valorSignatura = "z8N2uP5vR1qX9fbYwL4mK7jH3dA6sG0tQ9vC2xZ5nB8mJ1kL4pO7iU0yT3rE6wQ9".getBytes(StandardCharsets.UTF_8);

        DigitalSignature signa = new DigitalSignature(valorSignatura);

        valorSignatura[0] = (byte) '0';

        assertNotEquals(valorSignatura, signa.getSignature());

    }

    @Test
    public void formatIncorrecteTest() {
        byte[] signaturaFormatIncorrecte = "".getBytes();

        assertThrows(
                InvalidDigitalSignatureFormatException.class,
                () -> new DigitalSignature(signaturaFormatIncorrecte)
        );
    }

    @Test
    public void equalsTest() throws Exception {
        byte[] key1 = "z8N2uP5vR1qX9fbYwL4mK7jH3dA6sG0tQ9vC2xZ5nB8mJ1kL4pO7iU0yT3rE6wQ9".getBytes(StandardCharsets.UTF_8);
        byte[] key2 = "z8N2uP5vR1qX9fbYwL4mK7jH3dA6sG0tQ9vC2xZ5nB8mJ1kL4pO7iU0yT3rE6wQ9".getBytes(StandardCharsets.UTF_8);

        DigitalSignature o1 = new DigitalSignature(key1);
        DigitalSignature o2 = new DigitalSignature(key2);

        assertEquals(o1, o2);
    }

}
