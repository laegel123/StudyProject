package com.example.designpattern.singleton.example.entity;

public class ChocolateBoiler {
    private boolean empty;
    private boolean boiled;

    private static final ChocolateBoiler uniqueInstance = new ChocolateBoiler();

    private ChocolateBoiler() {
        empty = true;
        boiled = false;
    }

    public static ChocolateBoiler getInstance() {
        return uniqueInstance;
    }

    public void fill() {
        if (isEmpty()) {
            empty = false;
            boiled = false;
        }
    }

    public void boil() {
        if (!isEmpty() && !isBoiled()) {
            boiled = true;
        }
    }

    public void drain() {
        if (!isEmpty() && isBoiled()) {
            // todo

            empty = true;
        }
    }

    public boolean isEmpty() {
        return empty;
    }

    public boolean isBoiled() {
        return boiled;
    }
}
