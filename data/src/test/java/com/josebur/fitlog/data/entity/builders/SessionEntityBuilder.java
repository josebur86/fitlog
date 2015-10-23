package com.josebur.fitlog.data.entity.builders;

import com.josebur.fitlog.data.entity.SessionEntity;
import com.josebur.fitlog.data.entity.SetEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SessionEntityBuilder {
    private int id = 1;
    private int userId = 1;
    private int workoutId = 1;
    private int exerciseId = 1;
    private int repGoal = 1;
    private List<SetEntity> sets = Collections.emptyList();

    public SessionEntityBuilder withId(int id) {
        this.id = id;
        return this;
    }

    public SessionEntityBuilder withUserId(int userId) {
        this.userId = userId;
        return this;
    }

    public SessionEntityBuilder withWorkoutId(int workoutId) {
        this.workoutId = workoutId;
        return this;
    }

    public SessionEntityBuilder withExerciseId(int exerciseId) {
        this.exerciseId = exerciseId;
        return this;
    }

    public SessionEntityBuilder withRepGoal(int repGoal) {
        this.repGoal = repGoal;
        return this;
    }

    public SessionEntityBuilder withSets(List<SetEntity> sets) {
        this.sets = sets;
        return this;
    }

    public SessionEntityBuilder withSquatSession() {
        repGoal = 5;
        sets = new ArrayList<>();
        sets.add(new SetEntity(1));
        sets.add(new SetEntity(2));
        sets.add(new SetEntity(3));
        sets.add(new SetEntity(4));
        sets.add(new SetEntity(5));
        return this;
    }

    public SessionEntity build() {
        return new SessionEntity(id, userId, workoutId, exerciseId, repGoal, sets);
    }
}
