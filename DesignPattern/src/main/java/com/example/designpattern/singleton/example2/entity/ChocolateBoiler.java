package com.example.designpattern.singleton.example2.entity;

public enum ChocolateBoiler {
    INSTANCE;
    private boolean empty;
    private boolean boiled;

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
