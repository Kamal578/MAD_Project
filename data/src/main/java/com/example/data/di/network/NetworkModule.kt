package com.example.data.di.network

import com.example.data.datastore.api.DeezerApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * **NetworkModule**  
 * A Dagger module that provides network-related dependencies for the application.  
 * This module is responsible for setting up and providing a singleton instance of the `DeezerApi`.
 */
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    /**
     * Provides a singleton instance of `DeezerApi` for interacting with the Deezer API.
     *
     * This method uses Retrofit to create the API instance, setting up the base URL and
     * adding a `GsonConverterFactory` for JSON serialization/deserialization.
     *
     * @return The `DeezerApi` instance.
     *
     * Example Usage:
     * ```kotlin
     * @Inject
     * lateinit var deezerApi: DeezerApi
     *
     * lifecycleScope.launch {
     *     val genres = deezerApi.getGenresOfMusic()
     *     println(genres)
     * }
     * ```
     */
    @Provides
    @Singleton
    fun provideDeezerApi(): DeezerApi {
        return Retrofit.Builder()
            .baseUrl("https://api.deezer.com/") // Deezer API base URL.
            .addConverterFactory(GsonConverterFactory.create()) // Converter for JSON handling.
            .build()
            .create(DeezerApi::class.java) // Create and return the DeezerApi implementation.
    }
}
