import words.Word;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dictionary {

    private List<Word> words = new ArrayList<>();

    public Dictionary() {
    }

    public Dictionary(Word... words) {
        this.words = Arrays.asList(words);
    }

    public Dictionary(List<Word> words) {
        this.words = words;
    }

    public List<Word> getWords() {
        return words;
    }

    public void setWords(List<Word> words) {
        this.words = words;
    }
}
