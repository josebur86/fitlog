package com.josebur.fitlog.domain.builders;

import com.josebur.fitlog.domain.Session;
import com.josebur.fitlog.domain.Set;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SessionBuilder {
    private String exercise = "";
    private int repGoal = 0;
    private List<Set> sets = Collections.emptyList();

    public SessionBuilder withExercise(String exercise) {
        this.exercise = exercise;
        return this;
    }

    public SessionBuilder withRepGoal(int repGoal) {
        this.repGoal = repGoal;
        return this;
    }

    public SessionBuilder withSets(List<Set> sets) {
        this.sets = sets;
        return this;
    }

    public SessionBuilder withSquatSession() {
        repGoal = 5;
        sets = new ArrayList<Set>();
        sets.add(new Set(1));
        sets.add(new Set(2));
        sets.add(new Set(3));
        sets.add(new Set(4));
        sets.add(new Set(5));
        return this;
    }

    public Session build() {
        return new Session(exercise, repGoal, sets);
    }
}
