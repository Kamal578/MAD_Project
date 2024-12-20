package com.example.data.dto.albumTracks

import com.google.gson.annotations.SerializedName

/**
 * **AlbumTracksResponse**  
 * A data transfer object (DTO) representing the response for a list of tracks in an album.  
 * This class is used to parse and map JSON responses from the Deezer API for album tracks.
 *
 * @property data A list of `AlbumTracksData` objects, each representing a track in the album.
 * @property total The total number of tracks in the album. This value may be `null` if not provided by the API.
 * @property next The URL for the next page of results, if available. This value may be `null` if there are no more pages.
 */
data class AlbumTracksResponse(

    @SerializedName("data")
    var data: List<AlbumTracksData> = arrayListOf(),

    @SerializedName("total")
    var total: Int? = null,

    @SerializedName("next")
    var next: String? = null
)
