package com.example.musicalquizproject.network

import com.example.musicalquizproject.model.Track
import retrofit2.http.GET
import retrofit2.http.Query

interface DeezerApiInterface {
    @GET("search")
    suspend fun searchTracks(@Query("q") query: String): DeezerSearchResponse
}

// Response model for search
data class DeezerSearchResponse(
    val data: List<Track>
)
