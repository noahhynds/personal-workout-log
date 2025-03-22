package ui;

public enum Buttons {

    ADD_COMMENTS("ADD COMMENT"),
    ADD_EXERCISE("ADD EXERCISE"),
    CREATE_WORKOUT("CREATE NEW WORKOUT");

    private final String name;

    // EFFECTS: create name for buttons
    Buttons(String name) {
        this.name = name;
    }

    // EFFECTS: return button name
    public String getValue() {
        return name;
    }

}
