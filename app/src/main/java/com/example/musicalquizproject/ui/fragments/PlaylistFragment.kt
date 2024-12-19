package com.example.musicalquizproject.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.musicalquizproject.R
import com.example.musicalquizproject.ui.adapters.PlaylistAdapter
import com.example.musicalquizproject.viewmodel.PlaylistViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class PlaylistFragment : Fragment() {

    private lateinit var playlistViewModel: PlaylistViewModel
    private lateinit var adapter: PlaylistAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_playlist, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        playlistViewModel = ViewModelProvider(this).get(PlaylistViewModel::class.java)
        adapter = PlaylistAdapter()

        val recyclerView = view.findViewById<RecyclerView>(R.id.playlistRecyclerView)
        val addPlaylistButton = view.findViewById<FloatingActionButton>(R.id.addPlaylistButton)

        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter

        // Observe playlists and update the adapter
        playlistViewModel.getPlaylists().let { playlists ->
            adapter.submitList(playlists)
        }

        // Handle Add Playlist button click
        addPlaylistButton.setOnClickListener {
            // Here, you'd typically open a dialog to add a new playlist
            val newPlaylist = playlistViewModel.createSamplePlaylist() // Example function
            playlistViewModel.addPlaylist(newPlaylist)
            adapter.submitList(playlistViewModel.getPlaylists())
            Toast.makeText(context, "Playlist Added", Toast.LENGTH_SHORT).show()
        }
    }
}
