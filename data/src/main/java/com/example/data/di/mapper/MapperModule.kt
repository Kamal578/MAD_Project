package com.example.data.di.mapper

import com.example.common.mapper.DeezerListMapper
import com.example.common.mapper.DeezerMapper
import com.example.data.dto.albumTracks.AlbumTracksData
import com.example.data.dto.artist.ArtistResponse
import com.example.data.dto.artistAlbums.ArtistAlbumsData
import com.example.data.dto.favorite.FavoritesDbModel
import com.example.data.dto.genre.MusicGenreData
import com.example.data.dto.genreArtists.GenreArtistsData
import com.example.data.mapper.*
import com.example.domain.entity.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * **MapperModule**  
 * A Dagger module that binds mapper implementations to their respective interfaces for dependency injection.  
 * This ensures the availability of specific mappers across the application wherever required.
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class MapperModule {

    /**
     * Binds an implementation of `ArtistAlbumsListMapper` to the `DeezerListMapper` interface
     * for mapping artist album data to domain entities.
     *
     * @param artistAlbumsListMapper The implementation of the mapper.
     * @return The bound mapper interface.
     */
    @Binds
    @Singleton
    abstract fun bindArtistAlbumsListMapper(
        artistAlbumsListMapper: ArtistAlbumsListMapper
    ): DeezerListMapper<ArtistAlbumsData, ArtistAlbumsEntity>

    /**
     * Binds an implementation of `ArtistMapper` to the `DeezerMapper` interface
     * for mapping artist data to domain entities.
     *
     * @param artistMapper The implementation of the mapper.
     * @return The bound mapper interface.
     */
    @Binds
    @Singleton
    abstract fun bindArtistMapper(
        artistMapper: ArtistMapper
    ): DeezerMapper<ArtistResponse, ArtistEntity>

    /**
     * Binds an implementation of `FavoriteMapperDbtoE` to the `DeezerMapper` interface
     * for mapping database favorite models to domain entities.
     *
     * @param favoriteMapperDbToE The implementation of the mapper.
     * @return The bound mapper interface.
     */
    @Binds
    @Singleton
    abstract fun bindFavoriteMapperDbToE(
        favoriteMapperDbToE: FavoriteMapperDbtoE
    ): DeezerMapper<FavoritesDbModel, FavoritesEntity>

    /**
     * Binds an implementation of `FavoriteMapperEtoDb` to the `DeezerMapper` interface
     * for mapping domain favorite entities to database models.
     *
     * @param favoriteMapperEtoDb The implementation of the mapper.
     * @return The bound mapper interface.
     */
    @Binds
    @Singleton
    abstract fun bindFavoriteMapperEtoDb(
        favoriteMapperEtoDb: FavoriteMapperEtoDb
    ): DeezerMapper<FavoritesEntity, FavoritesDbModel>

    /**
     * Binds an implementation of `FavoritesListMapper` to the `DeezerListMapper` interface
     * for mapping a list of favorite database models to domain entities.
     *
     * @param favoriteListMapper The implementation of the mapper.
     * @return The bound mapper interface.
     */
    @Binds
    @Singleton
    abstract fun bindFavoriteListMapper(
        favoriteListMapper: FavoritesListMapper
    ): DeezerListMapper<FavoritesDbModel, FavoritesEntity>

    /**
     * Binds an implementation of `GenreArtistListMapper` to the `DeezerListMapper` interface
     * for mapping genre artist data to domain entities.
     *
     * @param genreArtistListMapper The implementation of the mapper.
     * @return The bound mapper interface.
     */
    @Binds
    @Singleton
    abstract fun bindGenreArtistListMapper(
        genreArtistListMapper: GenreArtistListMapper
    ): DeezerListMapper<GenreArtistsData, GenreArtistsEntity>

    /**
     * Binds an implementation of `MusicGenreListMapper` to the `DeezerListMapper` interface
     * for mapping music genre data to domain entities.
     *
     * @param musicGenreListMapper The implementation of the mapper.
     * @return The bound mapper interface.
     */
   
