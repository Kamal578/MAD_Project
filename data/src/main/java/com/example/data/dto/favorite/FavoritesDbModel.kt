package com.example.data.dto.favorite

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * **FavoritesDbModel**  
 * A data class representing a favorite song stored in the Room database.  
 * This class is annotated with `@Entity` to define a table in the Room database.
 *
 * @property id The unique identifier of the favorite song. This is also the primary key for the table.
 * @property title The title of the favorite song.
 * @property duration The duration of the song in seconds.
 * @property artistName The name of the artist who performed the song.
 * @property picture The URL to the album or song's picture/cover art.
 */
@Entity(tableName = "favorites_table")
data class FavoritesDbModel(

    @PrimaryKey
    var id: Int, // Unique ID for the song.

    var title: String, // Title of the song.

    var duration: Int, // Duration of the song in seconds.

    var artistName: String, // Name of the artist.

    var picture: String // URL for the album or song's picture.
)
