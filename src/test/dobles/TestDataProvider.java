package dobles;

import data.HealthCardID;
import data.ProductID;
import data.ePrescripCode;
import medicalconsultation.*;
import services.suggestions.InsertionSuggestion;
import services.suggestions.ModifySuggestion;
import services.suggestions.RemovalSuggestion;
import services.suggestions.Suggestion;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestDataProvider {
    public static HealthCardID generaCIP() throws Exception {
        return new HealthCardID("87ZHJA342JKASBND");
    }

    public static ProductID generaCodiProducte() throws Exception {
        return new ProductID("123456789012");
    }

    public static ePrescripCode generaCodiPrescription() throws Exception {
        return new ePrescripCode("1234567890");
    }

    public static MedicalHistory generaHistorialBuit() throws Exception {
        return new MedicalHistory(generaCIP(), 123);
    }

    public static MedicalHistory generaHistorialNoBuit() throws Exception {
        MedicalHistory m = new MedicalHistory(generaCIP(), 123);
        m.addMedicalHistoryAnnotations("No hay cambios significativos");
        m.addMedicalHistoryAnnotations("Le han crecido cuernos");

        return m;
    }

    public static MedicalPrescription generaPrescripcioVigent() throws Exception {
        Date d = new Date(2026, 01, 20);

        return new MedicalPrescription(
                generaCIP(),
                1,
                "Resfriado",
                generaCodiPrescription(),
                d
        );
    }

    public static MedicalPrescription generaPrescripcioCaducada() throws Exception {
        Date dCaducada = new Date(2000, 01, 01);

        return new MedicalPrescription(
                generaCIP(),
                1,
                "Gripe",
                generaCodiPrescription(),
                dCaducada
        );
    }

    public static TakingGuideline generaInstruccions() throws Exception {
        return new TakingGuideline(
                dayMoment.BEFORELUNCH,
                15.0f,
                1.0f,
                1.0f,
                FqUnit.DAY,
                "Tomar con abundante agua"
        );
    }

    public static String generaPrompt() {
        return "Respuesta de la IA (Sugerencias para Gripe):\n" +
                "Producto      | Dosis | Frec. | Instrucciones        | Acción\n" +
                "--------------------------------------------------------------\n" +
                "243516578917  | 1.0   | 1.0   | Tomar con agua       | I\n" +
                "640557143200  | ----- | ----- | -------------------- | R\n" +
                "243516578917  | 3.0   | ----- | -------------------- | M";
    }


    public static List<Suggestion> generaSuggestions() throws Exception {
        List<Suggestion> suggestions = new ArrayList<>();

        suggestions.add(new InsertionSuggestion(
                new ProductID("243516578917"),
                1.0f,
                1.0f,
                "DAY",
                15.0f,
                "BEFORELUNCH",
                "Tomar con agua"
        ));

        suggestions.add(new RemovalSuggestion(
                new ProductID("640557143200")
        ));

        suggestions.add(new ModifySuggestion(
                new ProductID("243516578917"),
                3.0f,
                null,
                null,
                null,
                null,
                null
        ));

        return suggestions;
    }
}
