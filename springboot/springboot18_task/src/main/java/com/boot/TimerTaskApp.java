package com.boot;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Alonso
 */
public class TimerTaskApp {
    public static void main(String[] args) {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("task run...");
            }
        };
        timer.schedule(task, 0, 2000);
    }
}
