package com.example.data.mapper

import com.example.common.mapper.DeezerListMapper
import com.example.data.dto.albumTracks.AlbumTracksData
import com.example.domain.entity.AlbumTracksEntity
import javax.inject.Inject

/**
 * **AlbumTracksListMapper**  
 * Maps a list of `AlbumTracksData` objects to a list of `AlbumTracksEntity` objects.  
 * Used for converting data from the data layer to the domain layer.
 */
class AlbumTracksListMapper @Inject constructor() : DeezerListMapper<AlbumTracksData, AlbumTracksEntity> {
    override fun map(input: List<AlbumTracksData>): List<AlbumTracksEntity> {
        return input.map {
            AlbumTracksEntity(
                id = it.id,
                duration = it.duration,
                artist = it.artist.name,
                preview = it.preview,
                type = it.type,
                title = it.title
            )
        }
    }
}
