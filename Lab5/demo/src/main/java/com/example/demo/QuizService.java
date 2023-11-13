package com.example.demo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizService {

    private List<QuizQuestion> quizQuestions;

    public QuizService() {
        // Initialize the quiz questions
        this.quizQuestions = new ArrayList<>();

        // Add some example questions
        QuizQuestion question1 = new QuizQuestion(
                "What is the capital of France?",
                List.of("Berlin", "Madrid", "Paris", "Rome"),
                "Paris"
        );

        QuizQuestion question2 = new QuizQuestion(
                "Which planet is known as the Red Planet?",
                List.of("Earth", "Mars", "Jupiter", "Venus"),
                "Mars"
        );

        QuizQuestion question3 = new QuizQuestion(
                "What is the largest mammal in the world?",
                List.of("Elephant", "Blue Whale", "Giraffe", "Hippopotamus"),
                "Blue Whale"
        );

        // Add the questions to the list
        quizQuestions.add(question1);
        quizQuestions.add(question2);
        quizQuestions.add(question3);
    }

    public List<QuizQuestion> getAllQuizQuestions() {
        return quizQuestions;
    }

    public QuizQuestion getQuizQuestionById(int questionId) {
        return quizQuestions.size() > questionId ? quizQuestions.get(questionId) : null;
    }

    public boolean isCorrectAnswer(int questionId, String userAnswer) {
        QuizQuestion quizQuestion = getQuizQuestionById(questionId);
        return quizQuestion != null && quizQuestion.getCorrectAnswer().equalsIgnoreCase(userAnswer);
    }
}
