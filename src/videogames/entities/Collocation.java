package videogames.entities;

import videogames.FlexionalClass;

import java.util.Objects;

public class Collocation {
    private Word mainWord;
    private Word subWord;

    public Collocation(videogames.entities.Word mainWord, videogames.entities.Word subWord) {
        this.mainWord = mainWord;
        this.subWord = subWord;
    }

    public static boolean canCollocate(Word word1, Word word2) {
        return !(FlexionalClass.UNDEFINED.equals(word1.getFlexionalClass()) ||
                FlexionalClass.UNDEFINED.equals(word2.getFlexionalClass()));
    }

    public Word getMainWord() {
        return mainWord;
    }

    public Word getSubWord() {
        return subWord;
    }

    public Collocation reverse() {
        return new Collocation(subWord, mainWord);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Collocation that = (Collocation) o;
        return (Objects.equals(mainWord, that.mainWord) &&
                Objects.equals(subWord, that.subWord));
    }

    @Override
    public int hashCode() {
        return Objects.hash(mainWord, subWord);
    }

    @Override
    public String toString() {
        return mainWord.getValue() + " " + subWord.getValue();
    }
}
