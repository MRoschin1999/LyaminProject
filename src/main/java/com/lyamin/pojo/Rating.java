package com.lyamin.pojo;

public enum Rating {
    ZERO(0),
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10);

    private final int val;

    Rating(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }
}
