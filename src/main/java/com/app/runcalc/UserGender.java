package com.app.runcalc;

public enum UserGender {
    MALE("Male"),
    FEMALE("Female");

    private final String displayValueGender;

    private UserGender(String displayValueGender) {
        this.displayValueGender = displayValueGender;
    }

    public String getDisplayValueGender() {
        return displayValueGender;
    }
}
