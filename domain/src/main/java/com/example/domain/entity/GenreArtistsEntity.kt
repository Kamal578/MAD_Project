package com.example.domain.entity

/**
 * **GenreArtistsEntity**  
 * Represents a domain model for an artist associated with a music genre.  
 * This model encapsulates details of artists categorized by genre in the domain layer.
 *
 * @property id The unique identifier of the artist.
 * @property name The name of the artist.
 * @property picture The URL to the artist's picture.
 * @property tracklist The URL to the artist's tracklist.
 * @property type The type of the object, typically "artist".
 */
data class GenreArtistsEntity(
    var id: Int,
    var name: String,
    var picture: String,
    var tracklist: String,
    var type: String,
)
