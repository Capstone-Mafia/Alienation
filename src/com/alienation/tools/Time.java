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
    public double elapsed(){
        Date date = new Date();
        nowTime = date.getTime();
        return nowTime-startTime;
    }
}
