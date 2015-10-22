package com.josebur.fitlog.data.entity;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class SetEntityTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void SetHasANumber() {
        int setNumber = 1;

        SetEntity set = new SetEntity(setNumber);

        assertEquals(setNumber, set.getSetNumber());
    }

    @Test
    public void SetNumberCannotBeZero() {
        thrown.expect(IllegalArgumentException.class);
        int setNumber = 0;

        new SetEntity(setNumber);
    }

    @Test
    public void SetNumberCannotBeLessThanZero() {
        thrown.expect(IllegalArgumentException.class);
        int setNumber = -1;

        new SetEntity(setNumber);
    }

    @Test
    public void ToStringIncludesTheSetNumber() {
        String expected = "Set: 1";

        SetEntity set = new SetEntity(1);

        assertEquals(expected, set.toString());
    }
}
