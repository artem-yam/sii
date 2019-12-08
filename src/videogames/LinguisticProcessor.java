package videogames;

import videogames.determinators.CollocationsDeterminator;
import videogames.determinators.GamesDeterminator;
import videogames.determinators.WordsDeterminator;
import videogames.entities.Dictionary;
import videogames.entities.Word;
import videogames.utils.FuzzyComparator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LinguisticProcessor {

    private WordsDeterminator wordsDeterminator;
    private CollocationsDeterminator collocationsDeterminator;
    private GamesDeterminator gamesDeterminator;


    public LinguisticProcessor() {
        Dictionary dictionary = Dictionary.getDefaultDictionary();

        wordsDeterminator =
                new WordsDeterminator(dictionary, new FuzzyComparator());
        collocationsDeterminator = new CollocationsDeterminator();
        gamesDeterminator = new GamesDeterminator(dictionary);
    }

    public static void main(String... args) {
        new LinguisticProcessor().run();
    }

    private void run() {

        try (Scanner input = new Scanner(System.in)) {

            do {
                System.out.println("_________________________");
                System.out.print("Введите вопрос: ");

                String line = input.nextLine().trim();

                String str1 = "qwe";
                String str2 = "qwe";
                System.out.println("Сравнение '" + str1 + "' и '"
                        + str2 + "' = " + new FuzzyComparator()
                        .isFuzzyEqual(str1, str2));

                if (!line.isEmpty()) {

                    List<String> sentenceWords =
                            Arrays.asList(
                                    line.split(
                                            "[\\s(\\s*[-,.?!]+\\s*)]+"));

                    System.out.println("\nСлова:");

                    List<Word> words =
                            wordsDeterminator.findWords(sentenceWords);

                    System.out.println("\nСловосочетания:");
                    System.out.println(
                            collocationsDeterminator.findCollocations(words));

                    System.out.println(gamesDeterminator.findGames(words));

                } else {
                    System.out
                            .println(
                                    "Введена пустая строка, повторите ввод.");
                }

            } while (true);

        }
    }


}