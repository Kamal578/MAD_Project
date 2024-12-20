package com.example.data.dto.genreArtists

import com.google.gson.annotations.SerializedName

/**
 * **GenreArtistsData**  
 * A data transfer object (DTO) representing an artist associated with a specific music genre.  
 * This class is used to parse and map JSON responses from the Deezer API for genre artists.
 *
 * @property id The unique identifier of the artist.
 * @property name The name of the artist.
 * @property picture The URL to the default picture of the artist.
 * @property pictureSmall The URL to a small-sized version of the artist's picture.
 * @property pictureMedium The URL to a medium-sized version of the artist's picture.
 * @property pictureBig The URL to a large-sized version of the artist's picture.
 * @property pictureXl The URL to an extra-large version of the artist's picture.
 * @property radio A flag indicating whether a Deezer radio channel exists for the artist.
 * @property tracklist The URL to a list of tracks by the artist.
 * @property type The type of the object, typically "artist".
 */
data class GenreArtistsData(

    @SerializedName("id")
    var id: Int, // Unique ID of the artist.

    @SerializedName("name")
    var name: String, // Name of the artist.

    @SerializedName("picture")
    var picture: String, // URL to the default picture of the artist.

    @SerializedName("picture_small")
    var pictureSmall: String, // URL to a small-sized version of the artist's picture.

    @SerializedName("picture_medium")
    var pictureMedium: String, // URL to a medium-sized version of the artist's picture.

    @SerializedName("picture_big")
    var pictureBig: String, // URL to a large-sized version of the artist's picture.

    @SerializedName("picture_xl")
    var pictureXl: String, // URL to an extra-large version of the artist's picture.

    @SerializedName("radio")
    var radio: Boolean, // Indicates if a Deezer radio channel exists for the artist.

    @SerializedName("tracklist")
    var tracklist: String, // URL to the list of tracks by the artist.

    @SerializedName("type")
    var type: String, // Type of the object, usually "artist".
)
