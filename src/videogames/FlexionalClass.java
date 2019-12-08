package videogames;

public enum FlexionalClass {
    NOUN(new String[]{
            // все существительные
            "", "ы", "и", "а", "я", "ь", "ами", "ой", "у", "е", "ам", "ом",
            "ах", "ях", "й", "ов", "ей", "ями", "ю", "ям", "ём", "ем"}),
    VERB(new String[]{
            // глагольные
            "у", "ю", "ешь", "ишь", "ет", "ит", "ем", "им", "ете", "ите",
            "ут", "ют", "ат", "ят", "ть", "ся", "л", "ли", "ла",
            // краткие причастия
            "н", "на", "ны", "но"}),
    IMMUTABLE(new String[]{}), // собственные и числа
    //PROPER_NOUN(new String[]{}), NUMBER(new String[]{}),
    UNDEFINED(new String[]{}) // неизвестные или незначимые
    ;

    private String[] endings;

    FlexionalClass(String[] endings) {
        this.endings = endings;
    }

    public String[] getEndings() {
        return endings;
    }
}
