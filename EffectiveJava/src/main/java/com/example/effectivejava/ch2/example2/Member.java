package com.example.effectivejava.ch2.example2;

public class Member {
    private String id;
    private String name;
    private int age;

    public static class Builder {
        // 필수 매개변수
        private final String id;

        // 선택 매개변수 (기본값으로 초기화)
        private String name = "";
        private int age = 0;

        // 필수 값 생성자
        public Builder(String id) {
            this.id = id;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Member build() {
            return new Member(this);
        }
    }

    private Member(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.age = builder.age;
    }
}
