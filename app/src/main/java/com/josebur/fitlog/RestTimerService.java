package com.josebur.fitlog;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.josebur.fitlog.utils.CountUpTimer;

public class RestTimerService extends Service {
    private TimerListener listener;
    private final IBinder binder = new TimerBinder();
    private final CountUpTimer timer = new CountUpTimer(1000) {
        @Override
        public void onTick(long timeSinceStarted) {
            if (listener != null) {
                listener.onTick(timeSinceStarted);
            }
        }
    };

    public class TimerBinder extends Binder {
        RestTimerService getService() {
            return RestTimerService.this;
        }
    }

    public interface TimerListener {
        void onTick(long time);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_NOT_STICKY;
    }

    public void startTimer() {
        if (timer.isStopped()) {
            timer.start();
        }
    }

    public boolean isTimerStopped() {
        return timer.isStopped();
    }

    public void stopTimer() {
        timer.stop();
    }

    public void setTimerListener(TimerListener listener) {
        this.listener = listener;
    }
}
