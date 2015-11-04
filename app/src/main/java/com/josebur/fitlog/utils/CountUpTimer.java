package com.josebur.fitlog.utils;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;

public abstract class CountUpTimer {

    private final long intervalMillis;
    private boolean stopped = true;
    private long timeStarted;
    public CountUpTimer(long intervalMillis) {
        this.intervalMillis = intervalMillis;
    }

    public synchronized final CountUpTimer start() {
        this.stopped = false;
        timeStarted = SystemClock.elapsedRealtime();
        handler.sendMessage(handler.obtainMessage(MSG));
        return this;
    }

    public synchronized final void stop() {
        this.stopped = true;
        handler.removeMessages(MSG);
    }

    public final boolean isStopped() {
        return stopped;
    }

    public abstract void onTick(long timeSinceStarted);

    private static final int MSG = 1;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            synchronized (CountUpTimer.this) {
                final long timeSinceStarted = SystemClock.elapsedRealtime() - timeStarted;

                long lastTickStart = SystemClock.elapsedRealtime();
                onTick(timeSinceStarted);

                // calculate delay for message
                long delay = lastTickStart + intervalMillis - SystemClock.elapsedRealtime();

                sendMessageDelayed(obtainMessage(MSG), delay);
            }
        }
    };
}
