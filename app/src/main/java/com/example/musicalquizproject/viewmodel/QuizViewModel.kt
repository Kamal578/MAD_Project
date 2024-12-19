package com.example.musicalquizproject.viewmodel

import androidx.lifecycle.ViewModel
import com.example.musicalquizproject.model.Quiz
import com.example.musicalquizproject.repository.QuizRepository

class QuizViewModel : ViewModel() {
    private val quizRepository = QuizRepository()

    fun addQuiz(quiz: Quiz) {
        quizRepository.addQuiz(quiz)
    }

    fun getQuizzes(): List<Quiz> {
        return quizRepository.getAllQuizzes()
    }
}
