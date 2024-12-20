package com.example.data.source.local

import com.example.common.ResponseResult
import com.example.data.dto.favorite.FavoritesDbModel

/**
 * **LocalDataSource**  
 * Interface for the local data source operations.  
 * This defines the methods required for interacting with the local database, specifically for managing favorite songs.
 */
interface LocalDataSource {

    /**
     * Adds a song to the favorites table in the local database.
     *
     * @param favoritesDbModel The `FavoritesDbModel` representing the song to be added.
     * @return A `ResponseResult` containing the added `FavoritesDbModel`.
     */
    suspend fun addSongToFavorites(favoritesDbModel: FavoritesDbModel): ResponseResult<FavoritesDbModel>

    /**
     * Retrieves all songs from the favorites table in the local database.
     *
     * @return A `ResponseResult` containing a list of `FavoritesDbModel`.
     */
    suspend fun getAllFavoriteSongs(): ResponseResult<List<FavoritesDbModel>>

    /**
     * Deletes a song from the favorites table in the local database.
     *
     * @param favoritesDbModel The `FavoritesDbModel` representing the song to be deleted.
     * @return A `ResponseResult` containing the deleted `FavoritesDbModel`.
     */
    suspend fun deleteSongToFavorites(favoritesDbModel: FavoritesDbModel): ResponseResult<FavoritesDbModel>

    /**
     * Retrieves a specific favorite song by its ID from the local database.
     *
     * @param id The unique ID of the favorite song to be retrieved.
     * @return A `ResponseResult` containing the retrieved `FavoritesDbModel`.
     */
    suspend fun getFavoriteSongWithId(id: Int): ResponseResult<FavoritesDbModel>
}
