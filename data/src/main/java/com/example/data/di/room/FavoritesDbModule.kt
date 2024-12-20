package com.example.data.di.room

import android.content.Context
import androidx.room.Room
import com.example.data.datastore.room.FavoritesDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

/**
 * **FavoritesDbModule**  
 * A Dagger module that provides dependencies related to the `FavoritesDatabase` and `FavoritesDao`.  
 * This module ensures that the database and DAO instances are available throughout the application lifecycle.
 */
@Module
@InstallIn(SingletonComponent::class)
object FavoritesDbModule {

    /**
     * Provides a singleton instance of `FavoritesDatabase`.
     *
     * This method initializes the Room database with the specified context, database class, and name.
     * The database is built using `Room.databaseBuilder`.
     *
     * @param context The application context required to create the database.
     * @return An instance of `FavoritesDatabase`.
     *
     * Example Usage:
     * ```kotlin
     * val database = favoritesDbModule.provideFavoritesDb(context)
     * ```
     */
    @Provides
    fun provideFavoritesDb(
        @ApplicationContext context: Context
    ): FavoritesDatabase = Room.databaseBuilder(
        context,
        FavoritesDatabase::class.java,
        "favorites_db" // Name of the database file.
    ).build()

    /**
     * Provides an instance of `FavoritesDao` from the `FavoritesDatabase`.
     *
     * This method retrieves the DAO object for interacting with the `favorites_table`.
     *
     * @param database The `FavoritesDatabase` instance from which the DAO is retrieved.
     * @return An instance of `FavoritesDao`.
     *
     * Example Usage:
     * ```kotlin
     * val dao = favoritesDbModule.provideProductDao(database)
     * dao.addSongToFavorites(favoriteSong)
     * ```
     */
    @Provides
    fun provideProductDao(database: FavoritesDatabase): FavoritesDao = database.favoritesDao()
}
