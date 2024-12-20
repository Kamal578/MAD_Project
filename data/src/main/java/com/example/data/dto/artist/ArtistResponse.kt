package com.example.data.dto.artist

import com.google.gson.annotations.SerializedName

/**
 * **ArtistResponse**  
 * A data transfer object (DTO) representing the response data for an artist from the Deezer API.  
 * This class is used to parse and map JSON data for an artist's details.
 *
 * @property id The unique identifier for the artist.
 * @property name The name of the artist.
 * @property picture The URL to the artist's default picture.
 * @property pictureSmall The URL to a small-sized picture of the artist.
 * @property pictureMedium The URL to a medium-sized picture of the artist.
 * @property pictureBig The URL to a large-sized picture of the artist.
 * @property pictureXl The URL to an extra-large picture of the artist.
 * @property radio A flag indicating whether a Deezer radio channel exists for the artist.
 * @property tracklist The URL to a list of tracks by the artist.
 * @property type The type of the object, typically "artist".
 */
data class ArtistResponse(

    @SerializedName("id")
    var id: Int,

    @SerializedName("name")
    var name: String,

    @SerializedName("picture")
    var picture: String,

    @SerializedName("picture_small")
    var pictureSmall: String,

    @SerializedName("picture_medium")
    var pictureMedium: String,

    @SerializedName("picture_big")
    var pictureBig: String,

    @SerializedName("picture_xl")
    var pictureXl: String,

    @SerializedName("radio")
    var radio: Boolean,

    @SerializedName("tracklist")
    var tracklist: String,

    @SerializedName("type")
    var type: String,
)
