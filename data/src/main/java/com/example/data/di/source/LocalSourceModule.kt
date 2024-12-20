package com.example.data.di.source

import com.example.data.source.local.LocalDataSource
import com.example.data.source.local.LocalDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * **LocalSourceModule**  
 * A Dagger module responsible for providing dependencies related to the local data source.  
 * This module binds the `LocalDataSourceImpl` implementation to the `LocalDataSource` interface
 * to ensure a clean separation of concerns and enable dependency injection.
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class LocalSourceModule {

    /**
     * Binds the `LocalDataSourceImpl` implementation to the `LocalDataSource` interface.
     *
     * This method ensures that wherever the `LocalDataSource` interface is injected,
     * the `LocalDataSourceImpl` implementation is provided.
     *
     * @param localDataSourceImpl The implementation of the `LocalDataSource` interface.
     * @return The bound `LocalDataSource` instance.
     *
     * Example Usage:
     * ```kotlin
     * @Inject
     * lateinit var localDataSource: LocalDataSource
     * 
     * localDataSource.saveData(data)
     * ```
     */
    @Binds
    @Singleton
    abstract fun bindLocalSource(
        localDataSourceImpl: LocalDataSourceImpl
    ): LocalDataSource
}
