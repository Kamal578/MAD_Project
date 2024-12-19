package com.example.musicalquizproject.repository

import com.example.musicalquizproject.network.RetrofitInstance

class TrackRepository {
    suspend fun searchTracks(query: String) = RetrofitInstance.api.searchTracks(query)
}
