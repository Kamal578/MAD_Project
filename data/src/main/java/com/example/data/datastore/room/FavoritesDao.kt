package com.example.data.datastore.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.dto.favorite.FavoritesDbModel

/**
 * **FavoritesDao**  
 * Data Access Object (DAO) interface for performing database operations related to favorite songs.  
 * This interface provides methods to add, remove, and retrieve favorite songs stored in a Room database.
 */
@Dao
interface FavoritesDao {

    /**
     * Inserts a song into the favorites table.
     *
     * If a song with the same ID already exists, it will be replaced due to the `OnConflictStrategy.REPLACE` strategy.
     *
     * @param song The [FavoritesDbModel] representing the song to be added to favorites.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addSongToFavorites(song: FavoritesDbModel)

    /**
     * Deletes a song from the favorites table.
     *
     * The song is identified and deleted based on its primary key in the database.
     *
     * @param song The [FavoritesDbModel] representing the song to be removed from favorites.
     */
    @Delete
    suspend fun deleteSongToFavorites(song: FavoritesDbModel)

    /**
     * Retrieves all songs stored in the favorites table.
     *
     * This method fetches all records in the favorites table and returns them as a list.
     *
     * @return A list of [FavoritesDbModel] representing all favorite songs in the database.
     *
     * Example Usage:
     * ```kotlin
     * val favoriteSongs = favoritesDao.getAllSongs()
     * ```
     */
    @Query("SELECT * FROM favorites_table")
    suspend fun getAllSongs(): List<FavoritesDbModel>

    /**
     * Retrieves a specific song from the favorites table using its unique ID.
     *
     * @param id The unique ID of the song to be retrieved.
     * @return A [FavoritesDbModel] representing the favorite song with the given ID, or `null` if no match is found.
     *
     * Example Usage:
     * ```kotlin
     * val song = favoritesDao.getFavoriteSongWithId(songId)
     * ```
     */
    @Query("SELECT * FROM favorites_table WHERE id = :id")
    suspend fun getFavoriteSongWithId(id: Int): FavoritesDbModel
}
