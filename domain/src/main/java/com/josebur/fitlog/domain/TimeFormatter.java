package com.josebur.fitlog.domain;

public class TimeFormatter {
    private static final long MINUTE_MILLIS = 60000;
    private static final long SECOND_MILLIS = 1000;

    public static String fromMillis(long milliseconds) {
        long minutes = milliseconds / MINUTE_MILLIS;
        long seconds = milliseconds % MINUTE_MILLIS / SECOND_MILLIS;
        return String.format("%d:%02d", minutes, seconds);
    }
}
