package com.example.data.source.local

import com.example.common.ResponseResult
import com.example.common.ResultError
import com.example.data.datastore.room.FavoritesDao
import com.example.data.dto.favorite.FavoritesDbModel
import javax.inject.Inject

/**
 * **LocalDataSourceImpl**  
 * Implementation of the `LocalDataSource` interface.  
 * This class performs CRUD operations on the local database for managing favorite songs, leveraging `FavoritesDao`.
 */
class LocalDataSourceImpl @Inject constructor(
    private val favoritesDao: FavoritesDao,
) : LocalDataSource {

    /**
     * Adds a song to the favorites table in the local database.
     *
     * @param favoritesDbModel The `FavoritesDbModel` representing the song to be added.
     * @return A `ResponseResult` containing the added `FavoritesDbModel` if successful, or an error otherwise.
     */
    override suspend fun addSongToFavorites(favoritesDbModel: FavoritesDbModel): ResponseResult<FavoritesDbModel> {
        return try {
            favoritesDao.addSongToFavorites(favoritesDbModel)
            ResponseResult.Success(favoritesDbModel) // Return success with the added song.
        } catch (e: Exception) {
            ResponseResult.Error.IOException( // Handle exceptions and wrap them in a ResponseResult.
                ResultError(
                    errorMessage = e.localizedMessage ?: "An error occurred while adding the song."
                )
            )
        }
    }

    /**
     * Retrieves all songs from the favorites table in the local database.
     *
     * @return A `ResponseResult` containing a list of `FavoritesDbModel` if successful, or an error otherwise.
     */
    override suspend fun getAllFavoriteSongs(): ResponseResult<List<FavoritesDbModel>> {
        return try {
            val response = favoritesDao.getAllSongs()
            ResponseResult.Success(response) // Return success with the list of songs.
        } catch (e: Exception) {
            ResponseResult.Error.IOException( // Handle exceptions and wrap them in a ResponseResult.
                ResultError(
                    errorMessage = e.localizedMessage ?: "An error occurred while retrieving favorite songs."
                )
            )
        }
    }

    /**
     * Deletes a song from the favorites table in the local database.
     *
     * @param favoritesDbModel The `FavoritesDbModel` representing the song to be deleted.
     * @return A `ResponseResult` containing the deleted `FavoritesDbModel` if successful, or an error otherwise.
     */
    override suspend fun deleteSongToFavorites(favoritesDbModel: FavoritesDbModel): ResponseResult<FavoritesDbModel> {
        return try {
            favoritesDao.deleteSongToFavorites(favoritesDbModel)
            ResponseResult.Success(favoritesDbModel) // Return success with the deleted song.
        } catch (e: Exception) {
            ResponseResult.Error.IOException( // Handle exceptions and wrap them in a ResponseResult.
                ResultError(
                    errorMessage = e.localizedMessage ?: "An error occurred while deleting the song."
                )
            )
        }
    }

    /**
     * Retrieves a specific favorite song by its ID from the local database.
     *
     * @param id The unique ID of the favorite song.
     * @return A `ResponseResult` containing the `FavoritesDbModel` if successful, or an error otherwise.
     */
    override suspend fun getFavoriteSongWithId(id: Int): ResponseResult<FavoritesDbModel> {
        return try {
            val response = favoritesDao.getFavoriteSongWithId(id)
            ResponseResult.Success(response) // Return success with the retrieved song.
        } catch (e: Exception) {
            ResponseResult.Error.IOException( // Handle exceptions and wrap them in a ResponseResult.
                ResultError(
                    errorMessage = e.localizedMessage ?: "An error occurred while retrieving the song."
                )
            )
        }
    }
}
