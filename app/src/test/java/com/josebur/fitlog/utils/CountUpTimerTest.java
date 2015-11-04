package com.josebur.fitlog.utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class CountUpTimerTest {
    @Test
    public void timerIsCreatedStopped() {
        long intervalMillis = 1000;
        CountUpTimer timer = new CountUpTimer(intervalMillis) {
            @Override
            public void onTick(long timeSinceStarted) {
            }
        };

        assertTrue(timer.isStopped());
    }
}