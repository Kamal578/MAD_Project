package com.example.data.dto.genreArtists

import com.google.gson.annotations.SerializedName

/**
 * **GenreArtistsResponse**  
 * A data transfer object (DTO) representing the response for a list of artists associated with a specific genre.  
 * This class is used to parse and map JSON responses from the Deezer API for genre artists.
 *
 * @property data A list of `GenreArtistsData` objects, each representing an artist associated with the genre.
 */
data class GenreArtistsResponse(

    @SerializedName("data")
    var data: ArrayList<GenreArtistsData> // List of artists associated with the genre.
)
