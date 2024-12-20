package com.example.domain.entity

/**
 * **FavoritesEntity**  
 * Represents a domain model for a favorite song.  
 * This model encapsulates details of a user's favorite songs in the domain layer.
 *
 * @property id The unique identifier of the favorite song.
 * @property title The title of the favorite song.
 * @property duration The duration of the song in seconds.
 * @property artistName The name of the artist who performed the song.
 * @property picture The URL to the song or album's picture.
 */
data class FavoritesEntity(
    var id: Int,
    var title: String,
    var duration: Int,
    var artistName: String,
    var picture: String,
)
