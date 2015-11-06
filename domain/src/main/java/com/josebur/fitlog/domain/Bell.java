package com.josebur.fitlog.domain;

public abstract class Bell {

    private static final long INTERVAL = 90;
    private static final long LAST = 300;

    public boolean shouldRing(long currentSecond) {
        return currentSecond == INTERVAL ||
               currentSecond == 2 * INTERVAL ||
               currentSecond == LAST;
    }

    public abstract void ring();
}
