package com.example.data.dto.artistAlbums

import com.google.gson.annotations.SerializedName

/**
 * **ArtistAlbumsResponse**  
 * A data transfer object (DTO) representing the response for a list of albums by an artist.  
 * This class is used to parse and map JSON responses from the Deezer API for artist albums.
 *
 * @property data A list of `ArtistAlbumsData` objects, each representing an album by the artist.
 * @property total The total number of albums for the artist. This value may be `null` if not provided by the API.
 */
data class ArtistAlbumsResponse(

    @SerializedName("data")
    var data: List<ArtistAlbumsData> = arrayListOf(),

    @SerializedName("total")
    var total: Int? = null
)
