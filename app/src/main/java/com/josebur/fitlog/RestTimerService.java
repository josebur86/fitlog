package com.josebur.fitlog;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;

import com.josebur.fitlog.utils.CountUpTimer;

public class RestTimerService extends Service {
    private final static int NOTIFICATION_ID = 1;
    private NotificationManager notificationManager;
    private TimerListener listener;
    private final IBinder binder = new TimerBinder();
    private final CountUpTimer timer = new CountUpTimer(1000) {
        @Override
        public void onTick(long timeSinceStarted) {
            Notification notification = createNotificationBuilder()
                    .setContentText(String.format("%d", timeSinceStarted / 1000))
                    .build();
            notificationManager.notify(NOTIFICATION_ID, notification);

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
        if (notificationManager == null) {
            notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        }

        return START_NOT_STICKY;
    }

    public void startTimer() {
        if (timer.isStopped()) {
            timer.start();

            startForeground(NOTIFICATION_ID, createNotificationBuilder().build());
        }
    }

    public boolean isTimerStopped() {
        return timer.isStopped();
    }

    public void stopTimer() {
        timer.stop();
        stopForeground(true);
    }

    public void setTimerListener(TimerListener listener) {
        this.listener = listener;
    }


    private NotificationCompat.Builder createNotificationBuilder() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_stat_av_av_timer)
                .setContentTitle("FitLog")
                .setContentText("000");

        Intent resultIntent = new Intent(this, ExerciseSessionActivity.class);

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(ExerciseSessionActivity.class);
        stackBuilder.addNextIntent(resultIntent);

        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

        builder.setContentIntent(resultPendingIntent);

        return builder;
    }
}
