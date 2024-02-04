package com.example.effectivejava.item06;

import java.util.regex.Pattern;

public class Roman {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        System.out.println(isRomanNumeral2("aaa"));

        long endTime = System.currentTimeMillis();
        String message = (endTime - startTime) + " 시간이 걸렸습니다.";
        System.out.println(message);
    }

    static boolean isRomanNumeral(String s) {
        return s.matches("^(?=.)M*(C[MD]|D?C{0,3})" +
                "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
    }

    private static final Pattern ROMAN = Pattern.compile(
            "^(?=.)M*(C[MD]|D?C{0,3})" +
            "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");

    static boolean isRomanNumeral2(String s) {
        return ROMAN.matcher(s).matches();
    }
}
