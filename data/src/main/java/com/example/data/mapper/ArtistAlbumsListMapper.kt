package com.example.data.mapper

import com.example.common.mapper.DeezerListMapper
import com.example.data.dto.artistAlbums.ArtistAlbumsData
import com.example.domain.entity.ArtistAlbumsEntity
import javax.inject.Inject

/**
 * **ArtistAlbumsListMapper**  
 * Maps a list of `ArtistAlbumsData` objects to a list of `ArtistAlbumsEntity` objects.  
 * Used for transforming album data from the data layer to the domain layer.
 */
class ArtistAlbumsListMapper @Inject constructor() : DeezerListMapper<ArtistAlbumsData, ArtistAlbumsEntity> {
    override fun map(input: List<ArtistAlbumsData>): List<ArtistAlbumsEntity> {
        return input.map {
            ArtistAlbumsEntity(
                id = it.id,
                title = it.title,
                tracklist = it.tracklist,
                type = it.type,
                picture = it.coverMedium,
                date = it.releaseDate
            )
        }
    }
}
