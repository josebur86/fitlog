package com.josebur.fitlog.domain;

public class Session {
    private final String exercise;
    private final int repGoal;
    public Session(String exercise, int repGoal) {
        this.exercise = exercise;
        this.repGoal = repGoal;
    }

    public String getExercise() {
        return exercise;
    }

    public int getRepGoal() {
        return repGoal;
    }
}
