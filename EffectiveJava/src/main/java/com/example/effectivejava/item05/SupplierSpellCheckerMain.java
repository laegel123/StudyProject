package com.example.effectivejava.item05;

public class SupplierSpellCheckerMain {
    public static void main(String[] args) {
        SupplierSpellChecker spellChecker = SupplierSpellChecker.createLexicon(EnglishDictionary::new);

        System.out.println(spellChecker.isValid("English"));
    }
}
