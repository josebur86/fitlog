package com.josebur.fitlog.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class TimeFormatterTest {
    @Test
    public void oneThousandMillisecondsDisplaysAtOneSecond() {
        assertEquals("0:01", TimeFormatter.fromMillis(1000));
    }

    @Test
    public void tenThousandMillisecondsDisplaysTenSeconds() {
        assertEquals("0:10", TimeFormatter.fromMillis(10000));
    }

    @Test
    public void sixtyThousandMillisecondsDisplaysOneMinute() {
        assertEquals("1:00", TimeFormatter.fromMillis(60000));
    }

    @Test
    public void minuteBorderTest() {
        assertEquals("0:59", TimeFormatter.fromMillis(59999));
        assertEquals("1:00", TimeFormatter.fromMillis(60999));
        assertEquals("1:59", TimeFormatter.fromMillis(119999));
    }
}
