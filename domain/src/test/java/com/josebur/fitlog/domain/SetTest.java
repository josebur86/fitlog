package com.josebur.fitlog.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

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

    @Test
    public void equalsTest() {
        Set a = new Set(1);
        Set b = new Set(1);
        Set c = new Set(2);

        assertEquals(a, a);
        assertEquals(a, b);
        assertNotEquals(a, c);
        assertNotEquals(a, null);
    }
}
