package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class QuizRunner {

    public static void main(String[] args) {

        ArrayList<Question> quizQuestions = new ArrayList<>();

        ArrayList<String> possibleAnswers1 = new ArrayList<>(Arrays.asList("1 - Abstraction", "2 - Polymorphism", "3 " +
                "- Inheritance", "4 - Encapsulation"));
        MultipleChoice mcQuestion1 = new MultipleChoice(1, "What OOP term refers to a mechanism that allows one class" +
                " to be based on another class, " +
                "thus receiving its properties and behaviors?", possibleAnswers1, 3);

        ArrayList<String> possibleAnswers2 = new ArrayList<>(Arrays.asList("1 - C", "2 - Python", "3 - JavaScript",
                "4 - Java", "5 - Swift"));
        ArrayList<Integer> correctAnswers2 = new ArrayList<>(Arrays.asList(1, 4, 5));
        Checkbox checkboxQuestion2 = new Checkbox(3, "Which of the following programming languages are strongly " +
                "typed?", possibleAnswers2, correctAnswers2);

        ArrayList<String> possibleAnswers3 = new ArrayList<>(Arrays.asList("1 - True", "2 - False"));
        TrueFalse trueFalseQuestion3 = new TrueFalse(1, "True or False: IntelliJ is considered an integrated " +
                "development environment (IDE).", possibleAnswers3, 1);

        quizQuestions.add(mcQuestion1);
        quizQuestions.add(checkboxQuestion2);
        quizQuestions.add(trueFalseQuestion3);

        Quiz myQuiz = new Quiz(quizQuestions);

        myQuiz.calculateTotalPossiblePoints(quizQuestions);
        myQuiz.runQuiz(quizQuestions);
        myQuiz.gradeQuiz();
    }
}
