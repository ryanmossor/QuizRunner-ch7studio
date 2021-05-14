package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Checkbox extends Question {

    private ArrayList<String> possibleAnswers;
    private ArrayList<Integer> correctAnswers;

    public Checkbox(int pointValue, String questionText, ArrayList<String> possibleAnswers,
                    ArrayList<Integer> correctAnswers) {
        super(pointValue, questionText);
        this.possibleAnswers = possibleAnswers;
        this.correctAnswers = correctAnswers;
    }

    @Override
    public void displayAnswers() {
        for (String option : this.possibleAnswers) {
            System.out.println(option);
        }
    }

    public boolean isCorrectAnswer(ArrayList<Integer> userAnswers) {
        Collections.sort(userAnswers);
        Collections.sort(this.correctAnswers);
        return userAnswers.equals(this.correctAnswers);
    }

    @Override
    public int getAnswers() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number that corresponds with the option you wish to choose.");
        String userAnswer = input.nextLine();

        ArrayList<Integer> userAnswersArray = new ArrayList<>();

        while (!userAnswer.equals("")) {
            if (Integer.parseInt(userAnswer) > possibleAnswers.size() || Integer.parseInt(userAnswer) < 1) {
                System.out.println("Invalid input. Enter a number that corresponds with the option you wish to choose, or press Enter to finish this question.");
                userAnswer = input.nextLine();
            } else if (userAnswersArray.contains(Integer.parseInt(userAnswer))) {
                System.out.println("You have already entered this answer. Choose another option, or press Enter to " +
                        "finish this question.");
                userAnswer = input.nextLine();
            } else {
                userAnswersArray.add(Integer.parseInt(userAnswer));
                System.out.println("Answer selected. Choose another option, or press Enter to finish this question.");
                userAnswer = input.nextLine();
            }
        }

        System.out.println(userAnswersArray);

        int checkboxScore = 0;

        for (int answer : userAnswersArray) {
            if (this.correctAnswers.contains(answer)) {
                // Increment score for correct answer
                checkboxScore++;
            }
        }

        for (int incorrectAnswer : userAnswersArray) {
            if (checkboxScore > 0 && !this.correctAnswers.contains(incorrectAnswer)) {
                // Decrement score for incorrect answer, but only if
                // user has already received points for a correct answer
                checkboxScore--;
            }
        }
        return checkboxScore;
    }
}
