package com.josebur.fitlog.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SessionTest {
    @Test
    public void sessionHasAnExercise() {
        String exercise = "Squat";
        int repGoal = 5;
        Session session = new Session(exercise, repGoal);

        assertEquals(exercise, session.getExercise());
    }

    @Test
    public void sessionHasARepGoal() {
        int repGoal = 5;
        Session session = new Session("squat", repGoal);

        assertEquals(repGoal, session.getRepGoal());
    }
}
