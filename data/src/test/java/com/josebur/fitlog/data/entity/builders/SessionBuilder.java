package com.josebur.fitlog.data.entity.builders;

import com.josebur.fitlog.data.entity.SessionEntity;
import com.josebur.fitlog.data.entity.SetEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SessionBuilder {
    private int id = 1;
    private int userId = 1;
    private int workoutId = 1;
    private int exerciseId = 1;
    private int repGoal = 1;
    private List<SetEntity> sets = Collections.emptyList();

    public SessionBuilder withId(int id) {
        this.id = id;
        return this;
    }

    public SessionBuilder withUserId(int userId) {
        this.userId = userId;
        return this;
    }

    public SessionBuilder withWorkoutId(int workoutId) {
        this.workoutId = workoutId;
        return this;
    }

    public SessionBuilder withExerciseId(int exerciseId) {
        this.exerciseId = exerciseId;
        return this;
    }

    public SessionBuilder withRepGoal(int repGoal) {
        this.repGoal = repGoal;
        return this;
    }

    public SessionBuilder withSets(List<SetEntity> sets) {
        this.sets = sets;
        return this;
    }

    public SessionEntity build() {
        return new SessionEntity(id, userId, workoutId, exerciseId, repGoal, sets);
    }
}
