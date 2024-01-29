package com.example.effectivejava.item05;

import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class SupplierTest {

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();

        for (int i = -1; i < 4; i++) {
            printRandom(i, getRandomWithSupplier());
        }

        System.out.println((System.currentTimeMillis() - startTime) / 1000 + "seconds");
    }

    static double getRandom() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);

        return Math.random();
    }

    static Supplier<Double> getRandomWithSupplier() {
        return () -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return Math.random();
        };
    }

    static void printRandom(int x, Supplier<Double> d) {
        if (x > 0) {
            System.out.println(d.get());
        }
    }
}
