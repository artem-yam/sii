package videogames.determinators;

import videogames.FlexionalClass;
import videogames.SearchParameter;
import videogames.entities.Dictionary;
import videogames.entities.Game;
import videogames.entities.Word;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class GamesDeterminator {

    private Dictionary dictionary;

    public GamesDeterminator(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public List<Game> findGames(List<Word> words) {
        List<Game> games = new ArrayList<>(dictionary.getGames());

        for (Word word : words) {
            try {
                if (word.getValue().length() == 4) {
                    int year = Integer.valueOf(word.getValue());

                    games = games.stream()
                            .filter(x -> (x.getPublishYear() == year)).collect(
                                    Collectors.toList());
                }
            } catch (NumberFormatException ignored) {
            }
        }

        for (SearchParameter param : SearchParameter.values()) {
            findByParam(param, games, words);
        }


        for (Word word : words) {
            if (FlexionalClass.IMMUTABLE.equals(word.getFlexionalClass())) {
                games = games.stream()
                        .filter(x -> (x.getTags().stream()
                                .anyMatch(word.getValue()::equalsIgnoreCase)))
                        .collect(Collectors.toList());
            }
        }

        return games;
    }


    private void findByParam(SearchParameter param, List<Game> games,
                             List<Word> words) {
        List<Word> tempList = new ArrayList<>();

        switch (param) {
            case DEVELOPER:
                tempList =
                        words.stream()
                                .filter(x -> (x.getValue().contains("разраб")))
                                .collect(Collectors.toList());
                break;
            case PUBLISHER:
                tempList =
                        words.stream()
                                .filter(x -> (x.getValue().contains("изда")))
                                .collect(Collectors.toList());
                break;
            case AWARD:
                tempList =
                        words.stream()
                                .filter(x -> (x.getValue().contains("награ")))
                                .collect(Collectors.toList());
                break;
        }

        if (tempList.size() == 1) {

            Word tempWord = tempList.get(0);
            String paramValue = "";

            if (words.indexOf(tempWord) < words.size() - 1 &&
                    FlexionalClass.IMMUTABLE
                            .equals(words.get(words.indexOf(tempWord) + 1)
                                    .getFlexionalClass())) {
                paramValue = words.get(words.indexOf(tempWord) + 1).getValue();
                words.remove(words.get(words.indexOf(tempWord) + 1));
            }

            if (!paramValue.isEmpty()) {
                Iterator<Game> iter = games.iterator();

                while (iter.hasNext()) {
                    Game game = iter.next();

                    boolean shouldRemove = false;

                    switch (param) {
                        case DEVELOPER:
                            shouldRemove =
                                    !paramValue.equalsIgnoreCase(
                                            game.getDeveloper());
                            break;
                        case PUBLISHER:
                            shouldRemove =
                                    !paramValue.equalsIgnoreCase(
                                            game.getPublisher());
                            break;
                        case AWARD:
                            shouldRemove = game.getAwards().stream()
                                    .noneMatch(paramValue::equalsIgnoreCase);

                            break;
                    }

                    if (shouldRemove) {
                        iter.remove();
                    }
                }
            }

        }
    }

}
