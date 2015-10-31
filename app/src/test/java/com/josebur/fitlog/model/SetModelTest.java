package com.josebur.fitlog.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SetModelTest {
    @Test
    public void SetModelHasANumber() {
        int setNumber = 1;
        SetModel model = new SetModel(setNumber);

        assertEquals(setNumber, model.getSetNumber());
    }
}