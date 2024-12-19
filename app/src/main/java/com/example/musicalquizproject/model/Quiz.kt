package com.example.musicalquizproject.model

data class Quiz(
    val id: Int,
    val name: String,
    val playlist: Playlist,
    val questions: List<QuizQuestion>
)

data class QuizQuestion(
    val track: Track,
    val options: List<String>, // Include correct and incorrect answers
    val correctAnswer: String
)
