package com.alienation.tools;

import com.alienation.coregamefiles.gameart.Death;

import java.util.Timer;
import java.util.TimerTask;

public class TimerThread {
    public void runTimer() throws InterruptedException {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                Death.death();
            }
        };
        Timer timer = new Timer();
        timer.schedule(timerTask, 10 * 60000);
    }
}
