package com.example.data.di.repository

import com.example.data.repository.DeezerRepositoryImpl
import com.example.domain.repository.DeezerRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * **RepositoryModule**  
 * A Dagger module responsible for providing repository-related dependencies.  
 * This module binds the implementation of the `DeezerRepository` to its interface, ensuring
 * a clean separation of concerns and enabling dependency injection.
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    /**
     * Binds the implementation of `DeezerRepositoryImpl` to the `DeezerRepository` interface.
     *
     * The `DeezerRepositoryImpl` serves as the concrete implementation for the repository, handling
     * data retrieval, business logic, and interaction with data sources (e.g., APIs or databases).
     *
     * @param deezerRepositoryImpl The implementation of the `DeezerRepository`.
     * @return The `DeezerRepository` interface that will be injected wherever needed.
     *
     * Example Usage:
     * ```kotlin
     * @Inject
     * lateinit var deezerRepository: DeezerRepository
     * 
     * lifecycleScope.launch {
     *     val genres = deezerRepository.getGenres()
     *     println(genres)
     * }
     * ```
     */
    @Binds
    @Singleton
    abstract fun bindDeezerRepository(
        deezerRepositoryImpl: DeezerRepositoryImpl
    ): DeezerRepository
}
