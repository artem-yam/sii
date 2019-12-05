import words.FuzzyComparator;
import words.entity.Game;
import words.entity.Word;

import java.util.*;
import java.util.stream.Stream;

public class Main {

    private Dictionary dictionary;
    private FuzzyComparator fuzzyComparator = new FuzzyComparator();
    private boolean appOn = false;

    public Main() {
        dictionary = Dictionary.getDefaultDictionary();
    }

    public static void main(String... args) {
        new Main().run();
    }

    private void run() {
        appOn = true;

        try (Scanner input = new Scanner(System.in)) {


            do {
                System.out.println("_________________________");
                System.out.print("Введите вопрос: ");

                String line = input.nextLine().trim();

                if (!line.isEmpty()) {

                    List<String> sentenceWords =
                            Arrays.asList(line.split("[\\s(\\s*[-,.]+\\s*)]+"));

                    System.out.println("Найденные слова:");

                    /*for (int i = 0; i < sentenceWords.length; i++) {
                        System.out.print(sentenceWords[i] +
                                ((i != sentenceWords.length - 1) ? ", " : ".\n"));
                    }*/

                    List<Word> words = findWords(sentenceWords);

                    System.out.println("_________________________");
                    System.out.println("Возможные словосочетания:");
                    System.out.println(findCollations(words));

                    //System.out.println(findGames(words));


                } else {
                    System.out
                            .println(
                                    "Введена пустая строка, повторите ввод.");
                }

            } while (appOn || input.hasNextLine());

        } finally {
            appOn = false;
        }
    }


    //TODO
    private List<Game> findGames(List<Word> words) {
        List<Game> games = new ArrayList<>();


        return games;
    }

    private List<Collocation> findCollations(List<Word> words) {
        Set<Collocation> collations = new HashSet<>();

        for (Word word : words) {
            List<Collocation> wordCollocations =
                    Collocation.findCollocations(word,
                            words.toArray(new Word[0]));

            System.out.println("-------------------------");

            if (wordCollocations.isEmpty()) {
                System.out.println(
                        "Словосочетания со словом \'" +
                                word.getValue() + "\' не найдены");
            } else {
                System.out.println("Словосочетания со словом \'" +
                        word.getValue() + "\': " + wordCollocations);
            }

            for (Collocation collocation : wordCollocations) {
                if (!(collations.contains(collocation) ||
                        collations.contains(collocation.reverse()))) {
                    collations.add(collocation);
                }
            }

        }


        return new ArrayList<>(collations);
    }


    private List<Word> findWords(List<String> words) {
        List<Word> resultWords = new ArrayList<>();

        for (String word : words) {

            System.out.println("-------------------------");

            boolean found = false;
            Word foundedWord = null;
            List<Word> rootWords = new ArrayList<>();

            for (int i = 0;
                 i < dictionary.getWords().size() && !found;
                 i++) {

                Word tempWord = dictionary.getWords().get(i);

                found = word.equalsIgnoreCase(tempWord.getValue());

                if (found) {
                    foundedWord = tempWord;
                } else {
                    Stream<String> endingsStream = Arrays.stream(
                            tempWord.getSpeechPart().getEndings());
                    if (
                            (word.contains(tempWord.getRoot()) &&
                                    endingsStream.anyMatch(word::endsWith)
                            ) && fuzzyComparator
                                    .isFuzzyEqual(word, tempWord.getValue())
                    ) {
                        rootWords.add(tempWord);
                    }
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

                if (!rootWords.isEmpty()) {
                    System.out.printf("Похожие слова: %s\n",
                            rootWords);
                }
            }
        }

        return resultWords;
    }


}