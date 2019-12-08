package videogames.entities;

import videogames.FlexionalClass;

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

        newDictionary.setGames(getDefaultGames());

        return newDictionary;
    }

    private static List<Word> getDefaultWords() {
        List<Word> words = new ArrayList<>();

        words.addAll(Arrays.asList(
                //Существительные
                new Word("игры", "игр", "игра",
                        Arrays.asList("ы"), FlexionalClass.NOUN)
                , new Word("компанией", "компани", "компания",
                        Arrays.asList("ей"), FlexionalClass.NOUN)
                , new Word("жанру", "жанр", "жанр",
                        Arrays.asList("у"), FlexionalClass.NOUN)
                , new Word("награды", "наград", "награда",
                        Arrays.asList("ы"), FlexionalClass.NOUN)

                //Глаголы
                , new Word("выпущены", "выпущ", "выпускать",
                        Arrays.asList("ен", "ы"), FlexionalClass.VERB)
                , new Word("изданы", "изда", "издать",
                        Arrays.asList("н", "ы"), FlexionalClass.VERB)
                , new Word("разработаны", "разработа", "разработать",
                        Arrays.asList("н", "ы"), FlexionalClass.VERB)
                , new Word("относятся", "относ", "относиться",
                        Arrays.asList("ят", "ся"), FlexionalClass.VERB)
                , new Word("получили", "получи", "получить",
                        Arrays.asList("л", "и"), FlexionalClass.VERB)

                // Имена собственные
                , new Word("NaughtyDog", null, null,
                        null, FlexionalClass.IMMUTABLE)
                , new Word("Ubisoft", null, null,
                        null, FlexionalClass.IMMUTABLE)
                , new Word("Rockstar", null, null,
                        null, FlexionalClass.IMMUTABLE)
                , new Word("Nintendo", null, null,
                        null, FlexionalClass.IMMUTABLE)
                , new Word("BioWare", null, null,
                        null, FlexionalClass.IMMUTABLE)
                , new Word("Bethesda", null, null,
                        null, FlexionalClass.IMMUTABLE)

                , new Word("CriticsAwards", null, null,
                        null, FlexionalClass.IMMUTABLE)
                , new Word("TheGameAwards", null, null,
                        null, FlexionalClass.IMMUTABLE)
                , new Word("GoldenJoystickAwards", null, null,
                        null, FlexionalClass.IMMUTABLE)
                , new Word("IGN", null, null,
                        null, FlexionalClass.IMMUTABLE)

                , new Word("RPG", null, null,
                        null, FlexionalClass.IMMUTABLE)
                , new Word("Action", null, null,
                        null, FlexionalClass.IMMUTABLE)
                , new Word("Strategy", null, null,
                        null, FlexionalClass.IMMUTABLE)
        ));

        return words;
    }

    private static List<Game> getDefaultGames() {
        List<Game> games = new ArrayList<>();

        games.addAll(Arrays.asList(
                new Game("Skyrim", "Bethesda",
                        "Bethesda", 2011,
                        Arrays.asList("GameSpot", "IGN", "AIAS"),
                        Arrays.asList("RPG", "Adventure", "OpenWorld"))));

        return games;
    }

    public List<Word> getWords() {
        return words;
    }

    public void setWords(List<Word> words) {
        this.words = words;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }
}
