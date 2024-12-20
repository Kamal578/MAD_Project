package com.example.domain.entity

/**
 * **AlbumTracksEntity**  
 * Represents a domain model for album tracks.  
 * This model is used in the domain layer to encapsulate track details for an album.
 *
 * @property id The unique identifier of the track.
 * @property title The title of the track.
 * @property duration The duration of the track in seconds.
 * @property preview The URL to a preview of the track.
 * @property type The type of the track object, typically "track".
 * @property artist The name of the artist associated with the track.
 */
data class AlbumTracksEntity(
    var id: Int,
    var title: String,
    var duration: Int,
    var preview: String,
    var type: String,
    var artist: String,
)
