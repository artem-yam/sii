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
                , new Word("разработчик", "разработчик", "разработчик",
                        null, FlexionalClass.NOUN)
                , new Word("издатель", "издател", "издатель",
                        Arrays.asList("ь"), FlexionalClass.NOUN)

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
                , new Word("награждены", "награжд", "награждать",
                        Arrays.asList("ен", "ы"), FlexionalClass.VERB)

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
                , new Word("Sony", null, null,
                        null, FlexionalClass.IMMUTABLE)
                , new Word("ElectronicArts", null, null,
                        null, FlexionalClass.IMMUTABLE)


                , new Word("GameCriticsAwards", null, null,
                        null, FlexionalClass.IMMUTABLE)
                , new Word("VideoGameAwards", null, null,
                        null, FlexionalClass.IMMUTABLE)
                , new Word("IGN", null, null,
                        null, FlexionalClass.IMMUTABLE)
                , new Word("GameSpot", null, null,
                        null, FlexionalClass.IMMUTABLE)
                , new Word("AIAS", null, null,
                        null, FlexionalClass.IMMUTABLE)
                , new Word("GameDevelopersChoiceAwards", null, null,
                        null, FlexionalClass.IMMUTABLE)
                , new Word("SpikeVideoGameAwards", null, null,
                        null, FlexionalClass.IMMUTABLE)
                , new Word("GoldenJoystickAwards", null, null,
                        null, FlexionalClass.IMMUTABLE)
                , new Word("TheGameAwards", null, null,
                        null, FlexionalClass.IMMUTABLE)


                , new Word("RPG", null, null,
                        null, FlexionalClass.IMMUTABLE)
                , new Word("Action", null, null,
                        null, FlexionalClass.IMMUTABLE)
                , new Word("Strategy", null, null,
                        null, FlexionalClass.IMMUTABLE)
                , new Word("OpenWorld", null, null,
                        null, FlexionalClass.IMMUTABLE)
                , new Word("Shooter", null, null,
                        null, FlexionalClass.IMMUTABLE)
                , new Word("Stealth", null, null,
                        null, FlexionalClass.IMMUTABLE)
                , new Word("Western", null, null,
                        null, FlexionalClass.IMMUTABLE)
                , new Word("SciFi", null, null,
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
                        Arrays.asList("RPG", "Adventure", "OpenWorld"))
                , new Game("Uncharted: Drake’s Fortune", "NaughtyDog",
                        "Sony", 2007,
                        Arrays.asList("IGN"),
                        Arrays.asList("Action", "Adventure", "Shooter"))
                , new Game("Assassin’s Creed", "Ubisoft",
                        "Ubisoft", 2007,
                        Arrays.asList("GameCriticsAwards", "IGN", "GameSpot"),
                        Arrays.asList("Action", "Adventure", "Stealth",
                                "OpenWorld"))
                , new Game("Red Dead Redemption", "Rockstar",
                        "Rockstar", 2010,
                        Arrays.asList("VideoGameAwards", "IGN", "GameSpot",
                                "GameDevelopersChoiceAwards",
                                "SpikeVideoGameAwards", "AIAS"),
                        Arrays.asList("Action", "Adventure", "Shooter",
                                "Western", "OpenWorld"))
                , new Game("The Legend of Zelda: Breath of the Wild",
                        "Nintendo", "Nintendo", 2017,
                        Arrays.asList("GameCriticsAwards", "IGN", "AIAS",
                                "GoldenJoystickAwards", "TheGameAwards"),
                        Arrays.asList("Action", "Adventure", "OpenWorld"))
                , new Game("Mass Effect 2",
                        "BioWare", "ElectronicArts", 2010,
                        Arrays.asList("AIAS", "GoldenJoystickAwards",
                                "SpikeVideoGameAwards", "IGN", "GameSpot"),
                        Arrays.asList("Action", "RPG", "Shooter", "SciFi"))

        ));

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
