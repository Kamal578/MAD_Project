package com.example.data.mapper

import com.example.common.mapper.DeezerListMapper
import com.example.data.dto.genreArtists.GenreArtistsData
import com.example.domain.entity.GenreArtistsEntity
import javax.inject.Inject

/**
 * **GenreArtistListMapper**  
 * Maps a list of `GenreArtistsData` objects to a list of `GenreArtistsEntity` objects.
 */
class GenreArtistListMapper @Inject constructor() : DeezerListMapper<GenreArtistsData, GenreArtistsEntity> {
    override fun map(input: List<GenreArtistsData>): List<GenreArtistsEntity> {
        return input.map {
            GenreArtistsEntity(
                id = it.id,
                name = it.name,
                picture = it.pictureMedium,
                type = it.type,
                tracklist = it.tracklist
            )
        }
    }
}
