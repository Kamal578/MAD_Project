package com.example.musicalquizproject.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.musicalquizproject.repository.TrackRepository
import kotlinx.coroutines.Dispatchers

class SearchViewModel : ViewModel() {
    private val trackRepository = TrackRepository()

    fun searchTracks(query: String) = liveData(Dispatchers.IO) {
        val result = trackRepository.searchTracks(query)
        emit(result.data)
    }
}
