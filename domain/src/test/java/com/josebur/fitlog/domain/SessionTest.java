package com.josebur.fitlog.domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SessionTest {
    @Test
    public void sessionHasAnExercise() {
        String exercise = "Squat";
        int repGoal = 5;
        List<Set> sets = Collections.emptyList();
        Session session = new Session(exercise, repGoal, sets);

        assertEquals(exercise, session.getExercise());
    }

    @Test
    public void sessionHasARepGoal() {
        int repGoal = 5;
        List<Set> sets = Collections.emptyList();
        Session session = new Session("squat", repGoal, sets);

        assertEquals(repGoal, session.getRepGoal());
    }

    @Test
    public void sessionHasAListOfSets() {
        int repGoal = 5;
        List<Set> sets = new ArrayList<>();
        sets.add(new Set(1));
        sets.add(new Set(2));

        Session session = new Session("squat", repGoal, sets);

        assertEquals(sets, session.getSets());
    }

    @Test
    public void equalsTest() {
        Session a = new Session("Squat", 5, Collections.<Set>emptyList());
        Session b = new Session("Squat", 5, Collections.<Set>emptyList());

        assertEquals(a, a);
        assertEquals(a, b);
    }
}
