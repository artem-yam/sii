import words.category.SpeechPart;
import words.entity.Word;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Collocation {
    private Word word1;
    private Word word2;

    public Collocation(Word word1, Word word2) {
        this.word1 = word1;
        this.word2 = word2;
    }

    public static boolean canCollocate(Word word1, Word word2) {
        return !SpeechPart.UNDEFINED.equals(word1.getSpeechPart()) &&
                !SpeechPart.UNDEFINED.equals(word2.getSpeechPart());
    }

    public static List<Collocation> findCollocations(Word word,
                                                     Word... possibleCollocations) {
        List<Collocation> result = new ArrayList<>();

        for (Word collocation : possibleCollocations) {
            if (canCollocate(word, collocation) &&
                    !collocation.equals(word)) {
                result.add(new Collocation(word, collocation));
            }
        }

        return result;
    }

    public Word getWord1() {
        return word1;
    }

    public Word getWord2() {
        return word2;
    }

    public Collocation reverse() {
        return new Collocation(word2, word1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Collocation that = (Collocation) o;
        return (Objects.equals(word1, that.word1) &&
                Objects.equals(word2, that.word2)) ||
                reverse().equals(that);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word1, word2);
    }

    @Override
    public String toString() {
        return word1.getValue() + " " + word2.getValue();
    }
}
