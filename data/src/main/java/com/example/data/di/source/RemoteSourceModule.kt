package com.example.data.di.source

import com.example.data.source.remote.RemoteDataSource
import com.example.data.source.remote.RemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * **RemoteSourceModule**  
 * A Dagger module responsible for providing dependencies related to the remote data source.  
 * This module binds the `RemoteDataSourceImpl` implementation to the `RemoteDataSource` interface,
 * facilitating clean architecture and enabling dependency injection.
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteSourceModule {

    /**
     * Binds the `RemoteDataSourceImpl` implementation to the `RemoteDataSource` interface.
     *
     * This method ensures that wherever the `RemoteDataSource` interface is injected,
     * the `RemoteDataSourceImpl` implementation is provided.
     *
     * @param remoteDataSourceImpl The implementation of the `RemoteDataSource` interface.
     * @return The bound `RemoteDataSource` instance.
     *
     * Example Usage:
     * ```kotlin
     * @Inject
     * lateinit var remoteDataSource: RemoteDataSource
     * 
     * remoteDataSource.fetchDataFromApi()
     * ```
     */
    @Binds
    @Singleton
    abstract fun bindDeezerRemoteDataSource(
        remoteDataSourceImpl: RemoteDataSourceImpl
    ): RemoteDataSource
}
