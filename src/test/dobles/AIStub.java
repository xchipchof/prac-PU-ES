package dobles;

import data.exceptions.NonUPCFormatException;
import services.DecisionMakingAI;
import services.exceptions.AIException;
import services.exceptions.BadPromptException;
import services.suggestions.Suggestion;

import java.util.List;

public class AIStub implements DecisionMakingAI {

    List<Suggestion> suggestions;

    @Override
    public void initDecisionMakingIA() throws AIException {

    }

    @Override
    public String getSuggestions(String prompt) throws BadPromptException {
        if (prompt == null || prompt.trim().isEmpty()) throw new BadPromptException("Prompt given was null or empty.");

        return TestDataProvider.generaPrompt();
    }

    @Override
    public List<Suggestion> parseSuggest(String aiAnswer) throws IllegalArgumentException, NonUPCFormatException {
        return TestDataProvider.generaSuggestions();
    }


}
