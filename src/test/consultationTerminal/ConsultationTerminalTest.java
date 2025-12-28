package consultationTerminal;


import consultationTerminal.exceptions.ProceduralException;
import dobles.*;
import data.*;
import services.DecisionMakingAI;
import services.HealthNationalService;
import services.exceptions.*;
import services.suggestions.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import java.net.ConnectException;
import java.util.List;

public class ConsultationTerminalTest {

    private ConsultationTerminal terminal;
    private DecisionMakingAI ai;
    private HealthNationalService SNS;
    private HealthCardID validCIP;
    private final String illness = "Gripe";

    @BeforeEach
    void setUp() throws Exception {
        terminal = new ConsultationTerminal();
        ai = new AIStub();
        validCIP = TestDataProvider.generaCIP();
        terminal.setDecisionMakingAI(ai);
    }

    @Test
    void testInitRevision_Success() throws Exception {
        SNS = new SuccessfulHealthNationalServiceMock();
        terminal.setHealthNationalService(SNS);

        assertDoesNotThrow(() -> terminal.initRevision(validCIP, illness));
    }

    @Test
    void testInitRevision_HealthCardIDException() {
        SNS = new InvalidCIPHealthNationalServiceMock();
        terminal.setHealthNationalService(SNS);

        assertThrows(HealthCardIDException.class, () ->
                terminal.initRevision(validCIP, illness));
    }

    @Test
    void testInitRevision_AnyCurrentPrescriptionException() {
        SNS = new NoPrescriptionHealthNationalServiceMock();
        terminal.setHealthNationalService(SNS);

        assertThrows(AnyCurrentPrescriptionException.class, () ->
                terminal.initRevision(validCIP, illness));
    }

    @Test
    void testInitRevision_ConnectException() {
        SNS = new ConnectionErrorHealthNationalServiceMock();
        terminal.setHealthNationalService(SNS);

        assertThrows(ConnectException.class, () ->
                terminal.initRevision(validCIP, illness));
    }


    @Test
    void testGetSuggestions_Success() throws Exception {
        terminal.setHealthNationalService(new SuccessfulHealthNationalServiceMock());
        terminal.initRevision(validCIP, illness);

        String evaluacion = "El paciente no mejora con el tratamiento actual.";
        String resultado = terminal.getSuggestions(evaluacion);

        assertNotNull(resultado);
        assertTrue(resultado.contains("243516578917"), "Debe contener el ProductID del factory");
        assertTrue(resultado.contains("I"), "Debe contener la operación de INSERT");
    }

    @Test
    void testGetSuggestions_BadPromptException() throws Exception {
        terminal.setHealthNationalService(new SuccessfulHealthNationalServiceMock());
        terminal.initRevision(validCIP, illness);

        assertThrows(BadPromptException.class, () -> terminal.getSuggestions(""));
    }

    @Test
    void testGetSuggestions_ProceduralException() {
        assertThrows(ProceduralException.class, () ->
                terminal.getSuggestions("Prompt válido"));
    }


    @Test
    void testParseSuggest_Consistency() throws Exception {
        terminal.setHealthNationalService(new SuccessfulHealthNationalServiceMock());
        terminal.initRevision(validCIP, illness);

        String aiResponse = terminal.getSuggestions("Cambiar dosis");

        List<Suggestion> suggestions = terminal.parseSuggest(aiResponse);

        assertNotNull(suggestions);
        assertEquals(3, suggestions.size(), "El factory genera 3 sugerencias");

        Suggestion s1 = suggestions.getFirst();
        assertInstanceOf(InsertionSuggestion.class, s1);
        assertEquals("243516578917", s1.getItem().getUPC());

        assertEquals("E", suggestions.get(1).getOperation());
    }
}
