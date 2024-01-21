package com.example.effectivejava.ch2;

import static com.example.effectivejava.ch2.NyPizza.Size.SMALL;
import static com.example.effectivejava.ch2.Pizza.Topping.*;

public class ch2Main {
    public static void main(String[] args) {
        NyPizza pizza = new NyPizza.Builder(SMALL)
                .addTopping(SAUSAGE)
                .addTopping(ONION)
                .build();

        Calzone calzone = new Calzone.Builder()
                .addTopping(HAM)
                .sauceInside()
                .build();
    }
}
