package videogames.determinators;

import videogames.FlexionalClass;
import videogames.SearchParameter;
import videogames.entities.Collocation;
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

    public List<Game> findGames(List<Collocation> collocations) {
        List<Game> games = new ArrayList<>(dictionary.getGames());

        Iterator<Collocation> colIterator = collocations.iterator();

        while (colIterator.hasNext()) {
            Collocation collocation = colIterator.next();

            Word colMainWord = collocation.getMainWord();
            Word colSubWord = collocation.getSubWord();

            boolean containsYear = false;
            try {
                if (colSubWord.getValue().length() == 4) {
                    int year = Integer.valueOf(colSubWord.getValue());

                    containsYear = true;

                    games = games.stream()
                            .filter(x -> (x.getPublishYear() == year)).collect(
                                    Collectors.toList());
                }
            } catch (NumberFormatException ignored) {
            }

            if (!containsYear) {

                SearchParameter param = null;

                if (colMainWord.getValue().contains("разраб")) {
                    param = SearchParameter.DEVELOPER;
                } else if (colMainWord.getValue().contains("изда")) {
                    param = SearchParameter.PUBLISHER;
                } else if (colMainWord.getValue().contains("награ")) {
                    param = SearchParameter.AWARD;
                }

                if (FlexionalClass.IMMUTABLE
                        .equals(colSubWord.getFlexionalClass())) {

                    if (param != null) {

                        Iterator<Game> iter = games.iterator();

                        while (iter.hasNext()) {
                            Game game = iter.next();

                            boolean shouldRemove = false;

                            switch (param) {
                                case DEVELOPER:
                                    shouldRemove =
                                            !colSubWord.getValue()
                                                    .equalsIgnoreCase(
                                                            game.getDeveloper());
                                    break;
                                case PUBLISHER:
                                    shouldRemove =
                                            !colSubWord.getValue()
                                                    .equalsIgnoreCase(
                                                            game.getPublisher());
                                    break;
                                case AWARD:
                                    shouldRemove = game.getAwards().stream()
                                            .noneMatch(colSubWord
                                                    .getValue()::equalsIgnoreCase);

                                    break;
                            }

                            if (shouldRemove &&
                                    game.getTags().stream()
                                            .noneMatch(colSubWord
                                                    .getValue()::equalsIgnoreCase)) {
                                iter.remove();
                            }
                        }
                    } else {
                        games = games.stream()
                                .filter(x -> (x.getTags().stream()
                                        .anyMatch(colSubWord
                                                .getValue()::equalsIgnoreCase)))
                                .collect(Collectors.toList());
                    }
                }
            }

            colIterator.remove();
        }

        return games;
    }

}
