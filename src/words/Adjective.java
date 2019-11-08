package words;

import words.category.Grammeme;
import words.category.SpeechPart;

import java.util.Arrays;

public class Adjective extends Word {

    //private GrammaticalGender gender;
    //private GrammaticalNumber number;

    public Adjective() {
        super(SpeechPart.ADJECTIVE);
    }

    public Adjective(Grammeme... grammemes) {
        super(SpeechPart.ADJECTIVE);

        getGrammemes().addAll(Arrays.asList(grammemes));
    }
}
