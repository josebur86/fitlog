package com.josebur.fitlog.domain;

import java.util.List;

public class Session {
    private final String exercise;
    private final int repGoal;
    private final List<Set> sets;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Session session = (Session) o;

        return repGoal == session.repGoal &&
               exercise.equals(session.exercise) &&
               sets.equals(session.sets);

    }

    @Override
    public int hashCode() {
        int result = exercise.hashCode();
        result = 31 * result + repGoal;
        result = 31 * result + sets.hashCode();
        return result;
    }
}
