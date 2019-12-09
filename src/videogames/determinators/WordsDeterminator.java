package videogames.determinators;

import videogames.FlexionalClass;
import videogames.entities.Dictionary;
import videogames.entities.Word;
import videogames.utils.FuzzyComparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class WordsDeterminator {

    private Dictionary dictionary;
    private FuzzyComparator fuzzyComparator;

    public WordsDeterminator(Dictionary dictionary,
                             FuzzyComparator fuzzyComparator) {
        this.dictionary = dictionary;
        this.fuzzyComparator = fuzzyComparator;
    }

    public List<Word> findWords(List<String> words) {
        List<Word> resultWords = new ArrayList<>();

        for (String word : words) {

            boolean found = false;
            Word foundedWord = null;

            for (int i = 0;
                 i < dictionary.getWords().size() && !found;
                 i++) {

                Word tempWord = dictionary.getWords().get(i);

                if (found = word.equalsIgnoreCase(tempWord.getValue())) {
                    foundedWord = tempWord;
                }
            }

            for (int i = 0;
                 i < dictionary.getWords().size() && !found;
                 i++) {

                Word tempWord = dictionary.getWords().get(i);

                Stream<String> endingsStream = Arrays.stream(
                        tempWord.getFlexionalClass().getEndings());
                if ((word.startsWith(tempWord.getRoot()) &&
                        endingsStream.anyMatch(word::endsWith)
                ) || fuzzyComparator
                        .isFuzzyEqual(word, tempWord.getValue())
                ) {
                    foundedWord = tempWord;
                    found = true;
                }
            }

            if (!found) {
                try {
                    if (word.length() == 4) {
                        int year = Integer.valueOf(word);

                        foundedWord = new Word(Integer.toString(year), null,
                                null, null, FlexionalClass.IMMUTABLE);
                        found = true;
                    }
                } catch (NumberFormatException ignored) {
                }
            }

            if (found) {
                resultWords.add(foundedWord);

                System.out
                        .printf("Слово \'%s\' обнаружено в словаре: %s\n",
                                word, foundedWord);
            } else {
                System.out
                        .printf("Слово \'%s\' НЕ обнаружено в словаре\n",
                                word);
            }
        }

        return resultWords;
    }

}
