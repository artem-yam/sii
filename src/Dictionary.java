import words.category.GrammaticalGender;
import words.category.GrammaticalNumber;
import words.category.GrammaticalTime;
import words.category.SpeechPart;
import words.entity.Game;
import words.entity.Word;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dictionary {

    private List<Word> words = new ArrayList<>();
    private List<Game> games = new ArrayList<>();

    public Dictionary() {
    }

    private Dictionary(List<Word> words) {
        this.words = words;
    }

    public static Dictionary getDefaultDictionary() {
        Dictionary newDictionary = new Dictionary(getDefaultWords());


        return newDictionary;
    }

    private static List<Word> getDefaultWords() {
        List<Word> words = new ArrayList<>();

        words.addAll(Arrays.asList(
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
                , new Word("консоль", "консол", null,
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
                        null, SpeechPart.IMMUTABLE)
                , new Word("Ubisoft", null, null,
                        null, SpeechPart.IMMUTABLE)
                , new Word("Rockstar", null, null,
                        null, SpeechPart.IMMUTABLE)
                , new Word("Nintendo", null, null,
                        null, SpeechPart.IMMUTABLE)
                , new Word("BioWare", null, null,
                        null, SpeechPart.IMMUTABLE)
                , new Word("Metacritic", null, null,
                        null, SpeechPart.IMMUTABLE)
                , new Word("IGN", null, null,
                        null, SpeechPart.IMMUTABLE)
                , new Word("GameSpot", null, null,
                        null, SpeechPart.IMMUTABLE)
                , new Word("PlayStation", null, null,
                        null, SpeechPart.IMMUTABLE)
                , new Word("Xbox", null, null,
                        null, SpeechPart.IMMUTABLE)
                , new Word("PC", null, null,
                        null, SpeechPart.IMMUTABLE)
                , new Word("Critics Awards", null, null,
                        null, SpeechPart.IMMUTABLE)
                , new Word("The Game Awards", null, null,
                        null, SpeechPart.IMMUTABLE)
                , new Word("Golden Joystick Awards", null, null,
                        null, SpeechPart.IMMUTABLE)
                , new Word("RPG", null, null,
                        null, SpeechPart.IMMUTABLE)
                , new Word("Action", null, null,
                        null, SpeechPart.IMMUTABLE)
        ));

        for (int year = 1960; year <= 2025; year++) {
            words.add(new Word(Integer.toString(year), null,
                    null, null, SpeechPart.IMMUTABLE));
        }
        return words;
    }

    private static List<Game> getDefaultGames() {
        List<Game> games = new ArrayList<>();

        games.addAll(Arrays.asList(
                new Game("Skyrim", "Bethesda", "Bethesda", "2011")));

        return games;
    }

    public List<Word> getWords() {
        return words;
    }

    public void setWords(List<Word> words) {
        this.words = words;
    }
}
