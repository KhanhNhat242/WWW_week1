package models;

public enum Is_Grant {
    ONE(1),
    ZERO(0),
    MINUS_ONE(-1);

    private final int value;
    private Is_Grant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
