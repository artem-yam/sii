package words;

import words.category.Grammeme;
import words.category.SpeechPart;

import java.util.Arrays;

public class Noun extends Word {

    //private GrammaticalGender gender;
    //private GrammaticalNumber number;

    public Noun() {
        super(SpeechPart.NOUN);
    }

    public Noun(Grammeme... grammemes) {
        super(SpeechPart.NOUN);

        getGrammemes().addAll(Arrays.asList(grammemes));
    }

}
