package com.example.musicalquizproject.model

data class Track(
    val id: String,
    val title: String,
    val duration: String,
    val artist: Artist,
    val album: Album
)

data class Artist(
    val id: String,
    val name: String,
    val picture: String
)

data class Album(
    val id: String,
    val title: String,
    val cover: String
)
