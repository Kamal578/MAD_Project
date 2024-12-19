package com.example.musicalquizproject.repository

import com.example.musicalquizproject.model.Quiz

class QuizRepository {
    private val quizzes = mutableListOf<Quiz>()

    fun addQuiz(quiz: Quiz) {
        quizzes.add(quiz)
    }

    fun getAllQuizzes(): List<Quiz> {
        return quizzes
    }
}
