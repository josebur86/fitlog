package com.josebur.fitlog.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SetTest {
    @Test
    public void setHasANumber() {
        int setNumber = 1;
        int setNumber2 = 2;

        Set set = new Set(setNumber);
        Set set2 = new Set(setNumber2);

        assertEquals(setNumber, set.getSetNumber());
        assertEquals(setNumber2, set2.getSetNumber());
    }
}
