package com.app.runcalc;

public enum ExerciseLevel {
    SEDENTARY("Sedentary"),
    LIGHTLY_ACTIVE("Lightly active"),
    MODERATELY_ACTIVE("Moderately active"),
    VERY_ACTIVE("Very active"),
    SUPER_ACTIVE("Super active");

    private final String displayValueEl;

    private ExerciseLevel(String displayValueEl) {
        this.displayValueEl = displayValueEl;
    }

    public String getDisplayValueEl() {
        return displayValueEl;
    }
}


