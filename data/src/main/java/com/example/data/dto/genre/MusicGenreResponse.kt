package com.example.data.dto.genre

import com.google.gson.annotations.SerializedName

/**
 * **MusicGenreResponse**  
 * A data transfer object (DTO) representing the response for a list of music genres.  
 * This class is used to parse and map JSON responses from the Deezer API for genres.
 *
 * @property data A list of `MusicGenreData` objects, each representing a music genre.
 */
data class MusicGenreResponse(

    @SerializedName("data")
    var data: List<MusicGenreData> // List of genres returned by the API.
)
