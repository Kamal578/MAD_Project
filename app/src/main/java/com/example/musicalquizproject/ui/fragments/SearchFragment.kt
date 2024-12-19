package com.example.musicalquizproject.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.musicalquizproject.R
import com.example.musicalquizproject.ui.adapters.TrackAdapter
import com.example.musicalquizproject.viewmodel.SearchViewModel

class SearchFragment : Fragment() {
    private lateinit var searchViewModel: SearchViewModel
    private lateinit var adapter: TrackAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        searchViewModel = ViewModelProvider(this).get(SearchViewModel::class.java)
        adapter = TrackAdapter()

        val searchBar = view.findViewById<EditText>(R.id.searchBar)
        val searchButton = view.findViewById<Button>(R.id.searchButton)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)

        recyclerView.layoutManager = GridLayoutManager(context, 2)
        recyclerView.adapter = adapter

        searchButton.setOnClickListener {
            val query = searchBar.text.toString()
            if (query.isEmpty()) {
                Toast.makeText(context, "Enter a search term", Toast.LENGTH_SHORT).show()
            } else {
                searchViewModel.searchTracks(query).observe(viewLifecycleOwner) { tracks ->
                    adapter.submitList(tracks)
                }
            }
        }
    }
}
