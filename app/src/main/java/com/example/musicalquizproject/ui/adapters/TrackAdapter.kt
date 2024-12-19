package com.example.musicalquizproject.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.musicalquizproject.R
import com.example.musicalquizproject.model.Track

class TrackAdapter : RecyclerView.Adapter<TrackAdapter.TrackViewHolder>() {

    private var tracks = listOf<Track>()

    fun submitList(newTracks: List<Track>) {
        tracks = newTracks
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrackViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_track, parent, false)
        return TrackViewHolder(view)
    }

    override fun onBindViewHolder(holder: TrackViewHolder, position: Int) {
        val track = tracks[position]
        holder.bind(track)
    }

    override fun getItemCount(): Int = tracks.size

    class TrackViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleView: TextView = itemView.findViewById(R.id.trackTitle)
        private val artistView: TextView = itemView.findViewById(R.id.artistName)
        private val imageView: ImageView = itemView.findViewById(R.id.albumCover)

        fun bind(track: Track) {
            titleView.text = track.title
            artistView.text = track.artist.name
            Glide.with(itemView.context).load(track.album.cover).into(imageView)
        }
    }
}
