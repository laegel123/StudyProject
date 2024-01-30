package com.example.effectivejava.item05;

import java.util.Objects;
import java.util.function.Supplier;

public class SupplierSpellChecker {

    private final Lexicon dictionary;

    private SupplierSpellChecker(Lexicon dictionary) {
        this.dictionary = dictionary;
    }

    public static SupplierSpellChecker createLexicon(Supplier<? extends Lexicon> dictionary) {
        Supplier<? extends Lexicon> lexiconSupplier = Objects.requireNonNull(dictionary);

        return new SupplierSpellChecker(lexiconSupplier.get());
    }

    public boolean isValid(String word) {
        // ....
        return true;
    }
}
