package com.company;

public abstract class Question {

    private int pointValue;
    private String questionText;

    public Question(int pointValue, String questionText) {
        this.pointValue = pointValue;
        this.questionText = questionText;
    }

    public int getPointValue() {
        return pointValue;
    }

    public void setPointValue(int pointValue) {
        this.pointValue = pointValue;
    }

    public void displayQuestion() {
        System.out.println(this.questionText);
    }

    public abstract void displayAnswers();

    public abstract int getAnswers();
}
