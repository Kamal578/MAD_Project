package com.example.domain.entity

/**
 * **ArtistAlbumsEntity**  
 * Represents a domain model for an artist's album.  
 * This model encapsulates details of albums in the domain layer.
 *
 * @property id The unique identifier of the album.
 * @property title The title of the album.
 * @property tracklist The URL to the tracklist of the album.
 * @property type The type of the album object, typically "album".
 * @property picture The URL to the album cover image.
 * @property date The release date of the album.
 */
data class ArtistAlbumsEntity(
    var id: Int,
    var title: String,
    var tracklist: String,
    var type: String,
    var picture: String,
    var date: String
)
