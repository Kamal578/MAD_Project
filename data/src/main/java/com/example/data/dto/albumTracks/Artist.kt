package com.example.data.dto.albumTracks

import com.google.gson.annotations.SerializedName

/**
 * **Artist**  
 * A data transfer object (DTO) representing an artist associated with a track or album.  
 * This class is used to parse and map JSON data for an artist from the Deezer API.
 *
 * @property id The unique identifier of the artist.
 * @property name The name of the artist.
 * @property tracklist The URL to the list of tracks by the artist.
 * @property type The type of the object, typically "artist".
 */
data class Artist(

    @SerializedName("id")
    var id: Int,

    @SerializedName("name")
    var name: String,

    @SerializedName("tracklist")
    var tracklist: String,

    @SerializedName("type")
    var type: String
)
