package com.josebur.fitlog;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.josebur.fitlog.utils.CountUpTimer;

public class ExerciseSessionActivity extends AppCompatActivity implements RestTimerService.TimerListener {
    private TextView secondsTextView; // TODO: throw this in a service that displays in a notification.

    RestTimerService restTimerService;
    boolean bound = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_session);

        secondsTextView = (TextView) findViewById(R.id.seconds);
        Button startButton = (Button) findViewById(R.id.startButton);
        Button stopButton = (Button) findViewById(R.id.stopButton);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bound && restTimerService != null) {
                    restTimerService.startTimer();
                }
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bound && restTimerService != null) {
                    restTimerService.stopTimer();
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        Intent intent = new Intent(ExerciseSessionActivity.this, RestTimerService.class);
        startService(intent);
        bindService(intent, connection, 0);
    }

    @Override
    protected void onStop() {
        super.onStop();

        if (bound) {
            boolean timerStopped = restTimerService.isTimerStopped();
            unbindService(connection);
            bound = false;
            if (timerStopped) {
                Intent intent = new Intent(this, RestTimerService.class);
                stopService(intent);
            }
        }
    }

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            RestTimerService.TimerBinder binder = (RestTimerService.TimerBinder)service;
            restTimerService = binder.getService();
            restTimerService.setTimerListener(ExerciseSessionActivity.this);
            bound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            bound = false;
        }
    };

    @Override
    public void onTick(long time) {
        secondsTextView.setText(String.format("%d", time / 1000));
    }


}
