package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class MultipleChoice extends Question {

    private ArrayList<String> possibleAnswers;
    private int correctAnswer;

    public MultipleChoice(int pointValue, String questionText, ArrayList<String> possibleAnswers, int correctAnswer) {
        super(pointValue, questionText);
        this.possibleAnswers = possibleAnswers;
        this.correctAnswer = correctAnswer;
    }

    @Override
    public void displayAnswers() {
        for (String option : this.possibleAnswers) {
            System.out.println(option);
        }
    }

    public boolean isCorrectAnswer(int userAnswer) {
        return userAnswer == this.correctAnswer;
    }

    @Override
    public int getAnswers() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number that corresponds with the option you wish to choose.");
        int userAnswer = input.nextInt();
        while (userAnswer < 1 || userAnswer > possibleAnswers.size()) {
            System.out.println("Invalid input. Enter a number that corresponds with the option you wish to choose.");
            userAnswer = input.nextInt();
        }
        if (isCorrectAnswer(userAnswer)) {
            return 1;
        } else {
            return 0;
        }
    }
}
