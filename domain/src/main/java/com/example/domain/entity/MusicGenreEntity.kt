package com.example.domain.entity

/**
 * **MusicGenreEntity**  
 * Represents a domain model for a music genre.  
 * This model encapsulates details of music genres in the domain layer.
 *
 * @property id The unique identifier of the music genre.
 * @property name The name of the music genre.
 * @property picture The URL to the picture representing the music genre.
 * @property type The type of the object, typically "genre".
 */
data class MusicGenreEntity(
    var id: Int,
    var name: String,
    var picture: String,
    var type: String
)
