import words.Word;
import words.category.GrammaticalGender;
import words.category.GrammaticalNumber;
import words.category.GrammaticalTime;
import words.category.SpeechPart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    private Dictionary dictionary;
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
                System.out.print("Введите вопрос: ");

                String line = input.nextLine().trim();

                if (!line.isEmpty()) {

                    String[] words = line.split("[\\s(\\s*[-,.]+\\s*)]+");

                    System.out.println("Найденные слова:");

                    for (int i = 0; i < words.length; i++) {
                        System.out.print(words[i] +
                                ((i != words.length - 1) ? ", " : ".\n"));
                    }


                    for (String word : words) {
                        boolean found = false;
                        for (Word dictionaryWord : dictionary.getWords()) {
                            if (dictionaryWord.getValue().equals(word)) {
                                found = true;

                                System.out.printf(
                                        "Слово \'%s\' обнаружено в словаре: %s\n",
                                        word, dictionaryWord);
                                break;
                            }
                        }
                    }
                    System.out.println("-------------------------");

                } else {
                    System.out
                            .println("Введена пустая строка, повторите ввод.");
                }

            } while (appOn || input.hasNextLine());

        } finally {
            appOn = false;
        }
    }

    private Dictionary fillDefaultDictionary() {
        List<Word> words = Arrays.asList(

                //Существительные
                new Word("игры", "игр", "игра",
                        Arrays.asList("ы"), SpeechPart.NOUN,
                        GrammaticalGender.FEMININE, GrammaticalNumber.PLURAL)
                , new Word("компанией", "компани", "компания",
                        Arrays.asList("ей"), SpeechPart.NOUN,
                        GrammaticalGender.FEMININE, GrammaticalNumber.SINGULAR)
                , new Word("жанру", "жанр", "жанр",
                        Arrays.asList("у"), SpeechPart.NOUN,
                        GrammaticalGender.MASCULINE, GrammaticalNumber.SINGULAR)
                , new Word("стратегия", "стратеги", null,
                        Arrays.asList("я"), SpeechPart.NOUN,
                        GrammaticalGender.FEMININE, GrammaticalNumber.SINGULAR)
                , new Word("версии", "верси", "версия",
                        Arrays.asList("и"), SpeechPart.NOUN,
                        GrammaticalGender.FEMININE, GrammaticalNumber.SINGULAR)
                , new Word("эксклюзивами", "эксклюзив", "эксклюзив",
                        Arrays.asList("ами"), SpeechPart.NOUN,
                        GrammaticalGender.MASCULINE, GrammaticalNumber.PLURAL)
                , new Word("эксклюзивами", "эксклюзив", "эксклюзив",
                        Arrays.asList("ами"), SpeechPart.NOUN,
                        GrammaticalGender.MASCULINE, GrammaticalNumber.PLURAL)
                , new Word("консоль", "консоль", null,
                        new ArrayList<>(), SpeechPart.NOUN,
                        GrammaticalGender.FEMININE, GrammaticalNumber.SINGULAR)
                , new Word("награды", "наград", "награда",
                        Arrays.asList("ы"), SpeechPart.NOUN,
                        GrammaticalGender.FEMININE, GrammaticalNumber.PLURAL)

                //Прилагательные
                , new Word("лучшими", "лучш", "лучший",
                        Arrays.asList("ими"), SpeechPart.ADJECTIVE,
                        GrammaticalGender.MASCULINE, GrammaticalNumber.PLURAL)

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