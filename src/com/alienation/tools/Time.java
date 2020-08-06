package com.alienation.tools;

import java.util.Date;
import java.util.TimerTask;
import java.awt.*;
import java.util.Timer;


public class Time {
    double startTime;
    double nowTime;

    public Time(){
        Date date = new Date();
        startTime = date.getTime();
    }
    public int secondsElapsed(){
        Date date = new Date();
        nowTime = date.getTime();
        return (int)((nowTime-startTime)/1000);
    }

    public String minutesElapsed(){
        int minutesElapsed = secondsElapsed()/60;
        int seconds = secondsElapsed()-minutesElapsed*60;
        String clock = minutesElapsed + " : " + seconds;
        return clock;
    }
}
