package com.example.benchmark.utility;

import java.util.concurrent.TimeUnit;

public class Utils {

    public static void deltaProfileing(Runnable task) {
        long startPoint = System.nanoTime();
        task.run();
        long total = System.nanoTime() - startPoint;
        System.out.println("Delta time: " + total + " ns");
    }
}
