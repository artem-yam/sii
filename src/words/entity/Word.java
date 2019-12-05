package words.entity;

import words.category.Grammeme;
import words.category.SpeechPart;

import java.util.*;

public class Word {

    private String baseForm;
    private String value;

    private String root;
    private List<String> affixes = new ArrayList<>();

    private SpeechPart speechPart = SpeechPart.UNDEFINED;
    private Set<Grammeme> grammemes = new HashSet<>();

    public Word() {
    }

    public Word(SpeechPart speechPart) {
        this.speechPart = speechPart;
    }

    public Word(String value, String root, String baseForm,
                List<String> affixes, SpeechPart speechPart,
                Grammeme... grammemes) {

        this.baseForm = (baseForm == null ? value : baseForm);
        this.value = value;
        this.root = (root == null ? value : root);
        this.affixes = affixes;
        this.speechPart = speechPart;
        this.grammemes = new HashSet<>(Arrays.asList(grammemes));
    }

    public String getBaseForm() {
        return baseForm;
    }

    public void setBaseForm(String baseForm) {
        this.baseForm = baseForm;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public List<String> getAffixes() {
        return affixes;
    }

    public void setAffixes(List<String> affixes) {
        this.affixes = affixes;
    }

    public void setAffixes(String... affixes) {
        this.affixes = Arrays.asList(affixes);
    }

    public SpeechPart getSpeechPart() {
        return speechPart;
    }

    public void setSpeechPart(SpeechPart speechPart) {
        this.speechPart = speechPart;
    }

    public Set<Grammeme> getGrammemes() {
        return grammemes;
    }

    public void setGrammemes(Set<Grammeme> grammemes) {
        this.grammemes = grammemes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word = (Word) o;
        return Objects.equals(baseForm, word.baseForm) &&
                Objects.equals(value, word.value) &&
                Objects.equals(root, word.root) &&
                Objects.equals(affixes, word.affixes) &&
                speechPart == word.speechPart &&
                Objects.equals(grammemes, word.grammemes);
    }

    @Override
    public int hashCode() {
        return Objects
                .hash(baseForm, value, root, affixes, speechPart, grammemes);
    }

    @Override
    public String toString() {
        return "слово = '" + value + '\'' +
                ", основа ='" + root + '\'' +
                ", начальная форма ='" + baseForm + '\'' +
                '}';
    }
}
