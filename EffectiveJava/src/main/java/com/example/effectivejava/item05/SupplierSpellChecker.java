package com.example.effectivejava.item05;

import java.util.function.Supplier;

public class SupplierSpellChecker {

    private Lexicon dictionary;

    public Lexicon create(Supplier<? extends Lexicon> lexiconFactory) {
        dictionary = lexiconFactory.get();
    }
}
