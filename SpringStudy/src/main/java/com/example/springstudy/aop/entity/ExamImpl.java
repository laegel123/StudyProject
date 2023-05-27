package com.example.springstudy.aop.entity;

public class ExamImpl implements Exam{
    int kor;
    int eng;
    int math;
    int com;

    public ExamImpl() {
    }

    public ExamImpl(int kor, int eng, int math, int com) {
        this.kor = kor;
        this.eng = eng;
        this.math = math;
        this.com = com;
    }

    @Override
    public int total() {
        int result = kor + eng + math + com;

        return result;
    }

    @Override
    public float avg() {
        float result = total() /4.0f;

        return result;
    }
}
