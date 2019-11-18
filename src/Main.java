import words.FuzzyComparator;
import words.category.GrammaticalGender;
import words.category.GrammaticalNumber;
import words.category.GrammaticalTime;
import words.category.SpeechPart;
import words.entity.Word;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    private Dictionary dictionary;
    private FuzzyComparator fuzzyComparator = new FuzzyComparator();
    private boolean appOn = false;

    public Main() {
        dictionary = fillDefaultDictionary();
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
                    findCollations(words);


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

    private List<Collocation> findCollations(List<Word> words) {
        List<Collocation> collations = new ArrayList<>();

        for (Word word : words) {
            // new Word[words.size()];
            List<Collocation> collocations =
                    Collocation.findCollocations(word,
                            words.toArray(new Word[0]));

            System.out.println("-------------------------");

            if (collocations.isEmpty()) {
                System.out.println(
                        "Словосочетания со словом \'" +
                                word.getValue() + "\' не найдены");
            } else {
                System.out.println("Словосочетания со словом \'" +
                        word.getValue() + "\': " + collocations);
            }
        }

        return collations;
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
                    if (word.contains(tempWord.getRoot()) ||
                            fuzzyComparator.isFuzzyEqual(word,
                                    tempWord.getValue())
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

    private Dictionary fillDefaultDictionary() {
        List<Word> words = Arrays.asList(

                //Существительные
                new Word("игры", "игр", "игра",
                        Arrays.asList("ы"), SpeechPart.NOUN,
                        GrammaticalGender.FEMININE,
                        GrammaticalNumber.PLURAL)
                , new Word("компанией", "компани", "компания",
                        Arrays.asList("ей"), SpeechPart.NOUN,
                        GrammaticalGender.FEMININE,
                        GrammaticalNumber.SINGULAR)
                , new Word("жанру", "жанр", "жанр",
                        Arrays.asList("у"), SpeechPart.NOUN,
                        GrammaticalGender.MASCULINE,
                        GrammaticalNumber.SINGULAR)
                , new Word("стратегия", "стратеги", null,
                        Arrays.asList("я"), SpeechPart.NOUN,
                        GrammaticalGender.FEMININE,
                        GrammaticalNumber.SINGULAR)
                , new Word("версии", "верси", "версия",
                        Arrays.asList("и"), SpeechPart.NOUN,
                        GrammaticalGender.FEMININE,
                        GrammaticalNumber.SINGULAR)
                , new Word("эксклюзивами", "эксклюзив", "эксклюзив",
                        Arrays.asList("ами"), SpeechPart.NOUN,
                        GrammaticalGender.MASCULINE,
                        GrammaticalNumber.PLURAL)
                , new Word("эксклюзивами", "эксклюзив", "эксклюзив",
                        Arrays.asList("ами"), SpeechPart.NOUN,
                        GrammaticalGender.MASCULINE,
                        GrammaticalNumber.PLURAL)
                , new Word("консоль", "консоль", null,
                        new ArrayList<>(), SpeechPart.NOUN,
                        GrammaticalGender.FEMININE,
                        GrammaticalNumber.SINGULAR)
                , new Word("награды", "наград", "награда",
                        Arrays.asList("ы"), SpeechPart.NOUN,
                        GrammaticalGender.FEMININE,
                        GrammaticalNumber.PLURAL)

                //Прилагательные
                , new Word("лучшими", "лучш", "лучший",
                        Arrays.asList("ими"), SpeechPart.ADJECTIVE,
                        GrammaticalGender.MASCULINE,
                        GrammaticalNumber.PLURAL)

                //Глаголы
                , new Word("выпущены", "выпущ", "выпускать",
                        Arrays.asList("ен", "ы"), SpeechPart.VERB,
                        GrammaticalNumber.PLURAL, GrammaticalTime.PAST)
                , new Word("изданы", "изда", "издать",
                        Arrays.asList("н", "ы"), SpeechPart.VERB,
                        GrammaticalNumber.PLURAL, GrammaticalTime.PAST)
                , new Word("разработаны", "разработа", "разработать",
                        Arrays.asList("н", "ы"), SpeechPart.VERB,
                        GrammaticalNumber.PLURAL, GrammaticalTime.PAST)
                , new Word("относятся", "относ", "относиться",
                        Arrays.asList("ят", "ся"), SpeechPart.VERB,
                        GrammaticalNumber.PLURAL, GrammaticalTime.PRESENT)
                , new Word("считаются", "счита", "считаться",
                        Arrays.asList("ют", "ся"), SpeechPart.VERB,
                        GrammaticalNumber.PLURAL, GrammaticalTime.PRESENT)
                , new Word("получили", "получи", "получить",
                        Arrays.asList("л", "и"), SpeechPart.VERB,
                        GrammaticalNumber.PLURAL, GrammaticalTime.PAST)
                , new Word("являются", "явля", "являться",
                        Arrays.asList("ют", "ся"), SpeechPart.VERB,
                        GrammaticalNumber.PLURAL, GrammaticalTime.PRESENT)

                // Имена собственные
                , new Word("Naughty Dog", null, null,
                        null, SpeechPart.PROPER_NOUN)
                , new Word("Ubisoft", null, null,
                        null, SpeechPart.PROPER_NOUN)
                , new Word("Rockstar", null, null,
                        null, SpeechPart.PROPER_NOUN)
                , new Word("Nintendo", null, null,
                        null, SpeechPart.PROPER_NOUN)
                , new Word("BioWare", null, null,
                        null, SpeechPart.PROPER_NOUN)
                , new Word("Metacritic", null, null,
                        null, SpeechPart.PROPER_NOUN)
                , new Word("IGN", null, null,
                        null, SpeechPart.PROPER_NOUN)
                , new Word("GameSpot", null, null,
                        null, SpeechPart.PROPER_NOUN)
                , new Word("PlayStation", null, null,
                        null, SpeechPart.PROPER_NOUN)
                , new Word("Xbox", null, null,
                        null, SpeechPart.PROPER_NOUN)
                , new Word("PC", null, null,
                        null, SpeechPart.PROPER_NOUN)
                , new Word("Critics Awards", null, null,
                        null, SpeechPart.PROPER_NOUN)
                , new Word("The Game Awards", null, null,
                        null, SpeechPart.PROPER_NOUN)
                , new Word("Golden Joystick Awards", null, null,
                        null, SpeechPart.PROPER_NOUN)
                , new Word("RPG", null, null,
                        null, SpeechPart.PROPER_NOUN)
                , new Word("Action", null, null,
                        null, SpeechPart.PROPER_NOUN)
        );

        return new Dictionary(words);
    }
}