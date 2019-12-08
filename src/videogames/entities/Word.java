package videogames.entities;

import videogames.FlexionalClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Word {

    private String baseForm;
    private String value;

    private String root;
    private List<String> affixes = new ArrayList<>();

    private FlexionalClass flexionalClass = FlexionalClass.UNDEFINED;

    public Word() {
    }

    public Word(FlexionalClass flexionalClass) {
        this.flexionalClass = flexionalClass;
    }

    public Word(String value, String root, String baseForm,
                List<String> affixes, FlexionalClass flexionalClass) {

        this.baseForm = (baseForm == null ? value : baseForm);
        this.value = value;
        this.root = (root == null ? value : root);
        this.affixes = affixes;
        this.flexionalClass = flexionalClass;
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

    public FlexionalClass getFlexionalClass() {
        return flexionalClass;
    }

    public void setFlexionalClass(FlexionalClass flexionalClass) {
        this.flexionalClass = flexionalClass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Word word = (Word) o;
        return Objects.equals(baseForm, word.baseForm) &&
                Objects.equals(value, word.value) &&
                Objects.equals(root, word.root) &&
                Objects.equals(affixes, word.affixes) &&
                flexionalClass == word.flexionalClass;
    }

    @Override
    public int hashCode() {
        return Objects
                .hash(baseForm, value, root, affixes, flexionalClass);
    }

    @Override
    public String toString() {
        return "слово = '" + value + '\'' +
                ", основа = '" + root + '\'' +
                ", начальная форма = '" + baseForm + '\'' +
                '}';
    }
}
