package com.example.domain.entity

/**
 * **ArtistEntity**  
 * Represents a domain model for an artist.  
 * This model encapsulates artist details in the domain layer.
 *
 * @property id The unique identifier of the artist.
 * @property name The name of the artist.
 * @property picture The URL to the artist's picture.
 * @property tracklist The URL to the artist's tracklist.
 * @property type The type of the object, typically "artist".
 */
data class ArtistEntity(
    var id: Int,
    var name: String,
    var picture: String,
    var tracklist: String,
    var type: String,
)
