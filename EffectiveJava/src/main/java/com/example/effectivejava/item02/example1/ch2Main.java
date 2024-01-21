package com.example.effectivejava.item02.example1;

import static com.example.effectivejava.item02.example1.NyPizza.Size.SMALL;
import static com.example.effectivejava.item02.example1.Pizza.Topping.*;

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
