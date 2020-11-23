package com.app.runcalc;

public enum TypeOfWorkout {
    RUN("Run"),
    CYCLE("Cycle"),
    SWIM("Swim");

    private final String displayValueTypeOfWorkout;

    private TypeOfWorkout(String displayValueTypeOfWorkout) {
        this.displayValueTypeOfWorkout = displayValueTypeOfWorkout;
    }

    public String getDisplayValueTypeOfWorkout() {
        return displayValueTypeOfWorkout;
    }

}
