package com.example.musicalquizproject.viewmodel

import androidx.lifecycle.ViewModel
import com.example.musicalquizproject.model.Playlist
import com.example.musicalquizproject.repository.PlaylistRepository

class PlaylistViewModel : ViewModel() {
    private val playlistRepository = PlaylistRepository()

    fun addPlaylist(playlist: Playlist) {
        playlistRepository.addPlaylist(playlist)
    }

    fun getPlaylists(): List<Playlist> {
        return playlistRepository.getAllPlaylists()
    }

    fun createSamplePlaylist(): Playlist {
        return Playlist(
            id = 0,
            name = "Sample Playlist",
            tracks = emptyList()
        )
    }
}
