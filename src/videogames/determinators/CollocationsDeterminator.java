package videogames.determinators;

import videogames.FlexionalClass;
import videogames.entities.Collocation;
import videogames.entities.Word;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CollocationsDeterminator {

    public CollocationsDeterminator() {
    }

    public List<Collocation> findCollocations(List<Word> words) {
        List<Collocation> result = new ArrayList<>();

        List<Word> paramWords = words.stream()
                .filter(x -> (x.getValue().contains("разраб") ||
                        x.getValue().contains("изда") ||
                        x.getValue().contains("награ")))
                .collect(Collectors.toList());

        if (!paramWords.isEmpty()) {

            for (Word paramName : paramWords) {

                Word paramValue;

                if (words.indexOf(paramName) < words.size() - 1 &&
                        FlexionalClass.IMMUTABLE
                                .equals(words.get(words.indexOf(paramName) + 1)
                                        .getFlexionalClass())) {
                    paramValue = words.get(words.indexOf(paramName) + 1);
                    words.remove(words.get(words.indexOf(paramName) + 1));

                    result.add(new Collocation(paramName, paramValue));
                }
            }
        }


        for (Word mainWord : words) {

            if (!FlexionalClass.IMMUTABLE
                    .equals(mainWord.getFlexionalClass())) {

                for (Word subWord : words) {

                    if (!mainWord.equals(subWord)
                            && Collocation.canCollocate(mainWord, subWord)
                    ) {

                        Collocation tempCollocation =
                                new Collocation(mainWord, subWord);

                        if (!result.contains(tempCollocation.reverse()) &&
                                result.stream().noneMatch(
                                        x -> (x.getSubWord()
                                                .equals(subWord)))) {
                            result.add(tempCollocation);
                        }
                    }
                }
            }
        }

        return result;
    }

}
