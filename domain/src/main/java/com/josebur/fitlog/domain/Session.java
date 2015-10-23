package com.josebur.fitlog.domain;

import java.util.List;

public class Session {
    private final String exercise;
    private final int repGoal;
    private List<Set> sets;

    public Session(String exercise, int repGoal, List<Set> sets) {
        this.exercise = exercise;
        this.repGoal = repGoal;
        this.sets = sets;
    }

    public String getExercise() {
        return exercise;
    }

    public int getRepGoal() {
        return repGoal;
    }

    public List<Set> getSets() {
        return sets;
    }
}
