package services;

import services.exceptions.AIException;
import services.exceptions.BadPromptException;
import services.suggestions.Suggestion;

import java.util.List;

public interface DecisionMakingAI {
    void initDecisionMakingIA() throws AIException;

    String getSuggestions(String prompt) throws BadPromptException;

    List<Suggestion> parseSuggest(String aiAnswer);
}
