package words.category;

import java.util.Arrays;
import java.util.List;

public enum SpeechPart {
    NOUN, PROPER_NOUN, VERB, ADJECTIVE, UNDEFINED;

    private List<SpeechPart> collocationPairs;

    public List<SpeechPart> getCollocationPairs() {
        return collocationPairs;
    }

    public void setCollocationPairs(SpeechPart... collocationPairs) {
        this.collocationPairs = Arrays.asList(collocationPairs);
    }
}
