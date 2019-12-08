package videogames.utils;

public class FuzzyComparator {

    private static final double THRESHOLD_WORD = 0.45;
    private static final int SUBTOKEN_LENGTH = 2;

    public boolean isFuzzyEqual(String firstToken, String secondToken) {
        int equalSubtokensCount = 0;

        boolean[] usedTokens =
                new boolean[secondToken.length() - SUBTOKEN_LENGTH + 1];

        for (int i = 0; i < firstToken.length() - SUBTOKEN_LENGTH + 1; ++i) {
            String subtokenFirst = firstToken.substring(i, i + SUBTOKEN_LENGTH);
            for (int j = 0; j < secondToken.length() - SUBTOKEN_LENGTH + 1;
                 ++j) {
                if (!usedTokens[j]) {
                    String subtokenSecond =
                            secondToken.substring(j, j + SUBTOKEN_LENGTH);
                    if (subtokenFirst.equals(subtokenSecond)) {
                        equalSubtokensCount++;
                        usedTokens[j] = true;
                        break;
                    }
                }
            }
        }

        int subtokenFirstCount = firstToken.length() - SUBTOKEN_LENGTH + 1;
        int subtokenSecondCount = secondToken.length() - SUBTOKEN_LENGTH + 1;

        double tanimoto = (1.0 * equalSubtokensCount) /
                (subtokenFirstCount + subtokenSecondCount -
                        equalSubtokensCount);

        return THRESHOLD_WORD <= tanimoto;
    }
}
