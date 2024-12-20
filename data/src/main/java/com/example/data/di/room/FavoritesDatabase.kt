package com.example.data.di.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.datastore.room.FavoritesDao
import com.example.data.dto.favorite.FavoritesDbModel

/**
 * **FavoritesDatabase**  
 * Represents the Room database for managing favorite songs in the application.  
 * This database contains a single table, represented by the `FavoritesDbModel` entity.
 *
 * @property entities The list of entities (tables) in the database. Currently, it includes `FavoritesDbModel`.
 * @property version The version of the database. Increment this value when making schema changes.
 * @property exportSchema Boolean indicating whether to export the database schema to a file. Set to `false` for simplicity.
 */
@Database(entities = [FavoritesDbModel::class], version = 1, exportSchema = false)
abstract class FavoritesDatabase : RoomDatabase() {

    /**
     * Provides an instance of `FavoritesDao`, which offers methods to access the `favorites_table`.
     *
     * The `FavoritesDao` is the primary interface for performing CRUD operations on the favorites table.
     *
     * @return An instance of `FavoritesDao`.
     *
     * Example Usage:
     * ```kotlin
     * val dao = database.favoritesDao()
     * dao.addSongToFavorites(favoriteSong)
     * ```
     */
    abstract fun favoritesDao(): FavoritesDao
}
