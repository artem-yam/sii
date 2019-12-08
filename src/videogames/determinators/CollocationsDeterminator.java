package videogames.determinators;

import videogames.entities.Collocation;
import videogames.entities.Word;
import videogames.FlexionalClass;

import java.util.ArrayList;
import java.util.List;

public class CollocationsDeterminator {
    
    public CollocationsDeterminator() {
    }

    public List<Collocation> findCollocations(List<Word> words) {
        List<Collocation> result = new ArrayList<>();

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
