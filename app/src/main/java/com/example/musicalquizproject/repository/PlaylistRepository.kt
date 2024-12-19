package com.example.musicalquizproject.repository

import com.example.musicalquizproject.model.Playlist

class PlaylistRepository {
    private val playlists = mutableListOf<Playlist>()

    fun addPlaylist(playlist: Playlist) {
        playlists.add(playlist)
    }

    fun getAllPlaylists(): List<Playlist> {
        return playlists
    }
}
