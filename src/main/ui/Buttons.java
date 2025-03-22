package ui;

public enum Buttons {

    HOME("HOME"),
    COMMENTS("VIEW COMMENTS"),
    ADD_EXERCISE("ADD EXERCISE"),
    VIEW_WORKOUTS("VIEW ALL"),
    CREATE_WORKOUT("CREATE NEW WORKOUT");

    private final String name;

    Buttons(String name) {
        this.name = name;
    }

    public String getValue() {
        return name;
    }

}
