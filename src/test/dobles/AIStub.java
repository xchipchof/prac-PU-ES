package dobles;

import services.DecisionMakingAI;
import services.exceptions.AIException;
import services.exceptions.BadPromptException;
import services.suggestions.Suggestion;

import java.util.List;

public class AIStub implements DecisionMakingAI {

    @Override
    public void initDecisionMakingIA() throws AIException {

    }

    @Override
    public String getSuggestions(String prompt) throws BadPromptException {
        return "";
    }

    @Override
    public List<Suggestion> parseSuggest(String aiAnswer) {
        return List.of();
    }


}
