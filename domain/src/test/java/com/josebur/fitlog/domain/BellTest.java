package com.josebur.fitlog.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BellTest {
    private Bell bell;

    @Before
    public void setup() {
        bell = new Bell() {
            @Override
            public void ring() {

            }
        };
    }
    @Test
    public void bellShouldNotRingAt1Second() {
        assertFalse(bell.shouldRing(1));
    }

    @Test
    public void bellShouldRingAt90Seconds() {
        assertTrue(bell.shouldRing(90));
    }

    @Test
    public void bellShouldRingAt180Seconds() {
        assertTrue(bell.shouldRing(180));
    }

    @Test
    public void bellShouldRingAt300Seconds() {
        assertTrue(bell.shouldRing(300));
    }
}

