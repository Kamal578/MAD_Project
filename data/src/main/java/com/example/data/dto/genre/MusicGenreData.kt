package com.example.data.dto.genre

import com.google.gson.annotations.SerializedName

/**
 * **MusicGenreData**  
 * A data transfer object (DTO) representing a music genre.  
 * This class is used to parse and map JSON responses from the Deezer API for genres.
 *
 * @property id The unique identifier of the music genre.
 * @property name The name of the music genre.
 * @property picture The URL to the default picture representing the genre.
 * @property pictureSmall The URL to a small-sized version of the genre's picture.
 * @property pictureMedium The URL to a medium-sized version of the genre's picture.
 * @property pictureBig The URL to a large-sized version of the genre's picture.
 * @property pictureXl The URL to an extra-large version of the genre's picture.
 * @property type The type of the object, typically "genre".
 */
data class MusicGenreData(

    @SerializedName("id")
    var id: Int, // Unique ID of the genre.

    @SerializedName("name")
    var name: String, // Name of the genre.

    @SerializedName("picture")
    var picture: String, // URL to the default picture for the genre.

    @SerializedName("picture_small")
    var pictureSmall: String, // URL to a small-sized version of the genre picture.

    @SerializedName("picture_medium")
    var pictureMedium: String, // URL to a medium-sized version of the genre picture.

    @SerializedName("picture_big")
    var pictureBig: String, // URL to a large-sized version of the genre picture.

    @SerializedName("picture_xl")
    var pictureXl: String, // URL to an extra-large version of the genre picture.

    @SerializedName("type")
    var type: String, // Type of this object, usually "genre".
)
