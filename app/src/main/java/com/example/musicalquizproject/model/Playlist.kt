package com.example.musicalquizproject.model

data class Playlist(
    val id: Int,
    val name: String,
    val tracks: List<Track>
)
