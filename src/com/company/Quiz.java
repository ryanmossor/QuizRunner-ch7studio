package com.company;

import java.util.ArrayList;

public class Quiz {

    private ArrayList<Question> quizQuestions;
    private double totalPossiblePoints;
    private double userScore;

    /*public Quiz(ArrayList<Question> quizQuestions, int totalPossiblePoints, int userScore) {
        this.quizQuestions = quizQuestions;
        this.totalPossiblePoints = totalPossiblePoints;
        this.userScore = userScore;
    }*/

    public Quiz(ArrayList<Question> quizQuestions) {
        this.quizQuestions = quizQuestions;
    }

    public void addQuestion(Question question) {
        this.quizQuestions.add(question);
    }

    public void runQuiz(ArrayList<Question> quiz) {
        for (Question question: quiz) {
            question.displayQuestion();
            question.displayAnswers();
            this.userScore += question.getAnswers();
            System.out.println("\n**********\n");
        }
    }

    public void calculateTotalPossiblePoints(ArrayList<Question> quiz) {
        for (Question question : quiz) {
            this.totalPossiblePoints += question.getPointValue();
        }
    }

    public void gradeQuiz() {
//        int percentageScore = (this.userScore / this.totalPossiblePoints) * 100;
        System.out.println("You scored " + (int) Math.floor(this.userScore) + " of " + (int) Math.floor(this.totalPossiblePoints) + " " +
                "possible points, " +
                "resulting in a grade of " + ((this.userScore / this.totalPossiblePoints) * 100) + "%.");
    }
}