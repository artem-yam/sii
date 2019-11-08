package words;

import words.category.Grammeme;
import words.category.SpeechPart;

import java.util.Arrays;

public class Verb extends Word {

    //private GrammaticalNumber number;
    //private GrammaticalTime time;

    public Verb() {
        super(SpeechPart.VERB);
    }

    public Verb(Grammeme... grammemes) {
        super(SpeechPart.VERB);

        getGrammemes().addAll(Arrays.asList(grammemes));
    }

}
