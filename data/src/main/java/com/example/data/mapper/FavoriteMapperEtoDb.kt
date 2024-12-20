package com.example.data.mapper

import com.example.common.mapper.DeezerMapper
import com.example.data.dto.favorite.FavoritesDbModel
import com.example.domain.entity.FavoritesEntity
import javax.inject.Inject

/**
 * **FavoriteMapperEtoDb**  
 * Maps `FavoritesEntity` from the domain layer to `FavoritesDbModel` for database storage.
 */
class FavoriteMapperEtoDb @Inject constructor() : DeezerMapper<FavoritesEntity, FavoritesDbModel> {
    override fun map(input: FavoritesEntity): FavoritesDbModel {
        return FavoritesDbModel(
            id = input.id,
            artistName = input.artistName,
            title = input.title,
            duration = input.duration,
            picture = input.picture
        )
    }
}
