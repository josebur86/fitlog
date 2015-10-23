package com.josebur.fitlog.data.entity;

import com.josebur.fitlog.data.entity.builders.SessionEntityBuilder;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SessionEntityTest {

    @Test
    public void sessionHasAnId() {
        int id = 1;
        int id2 = 2;

        SessionEntity session = new SessionEntityBuilder().withId(id).build();
        SessionEntity session2 = new SessionEntityBuilder().withId(id2).build();

        assertEquals(id, session.getId());
        assertEquals(id2, session2.getId());
    }

    @Test
    public void sessionHasAUserId() {
        int userId = 1;
        int userId2 = 2;

        SessionEntity session = new SessionEntityBuilder().withUserId(userId).build();
        SessionEntity session2 = new SessionEntityBuilder().withUserId(userId2).build();

        assertEquals(userId, session.getUserId());
        assertEquals(userId2, session2.getUserId());
    }

    @Test
    public void sessionHasAWorkoutId() {
        int workoutId = 1;
        int workoutId2 = 2;

        SessionEntity session = new SessionEntityBuilder().withWorkoutId(workoutId).build();
        SessionEntity session2 = new SessionEntityBuilder().withWorkoutId(workoutId2).build();

        assertEquals(workoutId, session.getWorkoutId());
        assertEquals(workoutId2, session2.getWorkoutId());
    }

    @Test
    public void sessionHasAnExerciseId() {
        int exerciseId = 3;
        int exerciseId2 = 4;

        SessionEntity session = new SessionEntityBuilder().withExerciseId(exerciseId).build();
        SessionEntity session2 = new SessionEntityBuilder().withExerciseId(exerciseId2).build();

        assertEquals(exerciseId, session.getExerciseId());
        assertEquals(exerciseId2, session2.getExerciseId());
    }

    @Test
    public void sessionHasARepGoalForAllSets() {
        int repGoal = 5;
        int repGoal2 = 10;

        SessionEntity session = new SessionEntityBuilder().withRepGoal(repGoal).build();
        SessionEntity session2 = new SessionEntityBuilder().withRepGoal(repGoal2).build();

        assertEquals(repGoal, session.getRepGoal());
        assertEquals(repGoal2, session2.getRepGoal());
    }

    @Test
    public void sessionHasAListOfSets() {
        List<SetEntity> sets = new ArrayList<>();
        sets.add(new SetEntity(1));
        sets.add(new SetEntity(2));
        List<SetEntity> sets2 = new ArrayList<>();
        sets.add(new SetEntity(1));
        sets.add(new SetEntity(2));
        sets.add(new SetEntity(3));

        SessionEntity session = new SessionEntityBuilder().withSets(sets).build();
        SessionEntity session2 = new SessionEntityBuilder().withSets(sets2).build();

        assertEquals(sets.size(), session.getSets().size());
        assertEquals(sets2.size(), session2.getSets().size());
    }

    @Test
    public void equalsTest() {
        SessionEntity a = new SessionEntityBuilder().withSquatSession().build();
        SessionEntity b = new SessionEntityBuilder().withSquatSession().build();

        assertEquals(a, a);
        assertEquals(a, b);
    }
}
