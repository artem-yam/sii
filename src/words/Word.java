package words;

import words.category.Grammeme;

import java.util.*;

public class Word {

    private String baseForm;
    private String value;

    private String root;
    private List<String> affixes = new ArrayList<>();

    private Set<Grammeme> grammemes = new HashSet<>();

    public Word() {
    }

    public Word(Grammeme grammeme) {
        grammemes = new HashSet<>(Arrays.asList(grammeme));
    }

    public Word(String value, String root, String baseForm,
                List<String> affixes, Grammeme... grammemes) {

        this.baseForm = (baseForm == null ? value : baseForm);
        this.value = value;
        this.root = (root == null ? value : root);
        this.affixes = affixes;
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

    public Set<Grammeme> getGrammemes() {
        return grammemes;
    }

    public void setGrammemes(Set<Grammeme> grammemes) {
        this.grammemes = grammemes;
    }

    @Override
    public String toString() {
        return "слово = '" + value + '\'' +
                ", основа ='" + root + '\'' +
                ", начальная форма ='" + baseForm + '\'' +
                '}';
    }
}
