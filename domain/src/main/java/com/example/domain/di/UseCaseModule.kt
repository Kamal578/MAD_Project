package com.example.domain.di

import com.example.domain.usecase.addSongToFavorites.AddSongToFavoritesUseCase
import com.example.domain.usecase.addSongToFavorites.AddSongToFavoritesUseCaseImpl
import com.example.domain.usecase.deleteSongFavorites.DeleteSongFavoritesUseCase
import com.example.domain.usecase.deleteSongFavorites.DeleteSongFavoritesUseCaseImpl
import com.example.domain.usecase.getAlbumTracksWithAlbumId.GetAlbumTracksWithAlbumIdUseCase
import com.example.domain.usecase.getAlbumTracksWithAlbumId.GetAlbumTracksWithAlbumIdUseCaseImpl
import com.example.domain.usecase.getAllFavoriteSongs.GetAllFavoriteSongsUseCase
import com.example.domain.usecase.getAllFavoriteSongs.GetAllFavoriteSongsUseCaseImpl
import com.example.domain.usecase.getAllGenresOfMusic.GetAllGenresOfMusicUseCase
import com.example.domain.usecase.getAllGenresOfMusic.GetAllGenresOfMusicUseCaseImpl
import com.example.domain.usecase.getArtistAlbumsWithArtistId.GetArtistAlbumsWithArtistIdUseCase
import com.example.domain.usecase.getArtistAlbumsWithArtistId.GetArtistAlbumsWithArtistIdUseCaseImpl
import com.example.domain.usecase.getArtistWithArtistId.GetArtistWithArtistIdUseCase
import com.example.domain.usecase.getArtistWithArtistId.GetArtistWithArtistIdUseCaseImpl
import com.example.domain.usecase.getFavoriteSongWithId.GetFavoriteSongWithIdUseCase
import com.example.domain.usecase.getFavoriteSongWithId.GetFavoriteSongWithIdUseCaseImpl
import com.example.domain.usecase.getGenreArtistsWithGenreId.GetGenreArtistsWithGenreIdUseCase
import com.example.domain.usecase.getGenreArtistsWithGenreId.GetGenreArtistsWithGenreIdUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

/**
 * **UseCaseModule**  
 * A Dagger module that binds use case implementations to their respective interfaces.  
 * This module ensures that the domain layer use cases are available for injection in ViewModels.
 */
@Module
@InstallIn(ViewModelComponent::class)
abstract class UseCaseModule {

    /**
     * Binds the `AddSongToFavoritesUseCaseImpl` implementation to the `AddSongToFavoritesUseCase` interface.
     */
    @Binds
    @ViewModelScoped
    abstract fun bindAddSongToFavoritesUseCase(
        addSongToFavoritesUseCaseImpl: AddSongToFavoritesUseCaseImpl
    ): AddSongToFavoritesUseCase

    /**
     * Binds the `DeleteSongFavoritesUseCaseImpl` implementation to the `DeleteSongFavoritesUseCase` interface.
     */
    @Binds
    @ViewModelScoped
    abstract fun bindDeleteSongFavoriteUseCase(
        deleteSongFavoritesUSeCaseImpl: DeleteSongFavoritesUseCaseImpl
    ): DeleteSongFavoritesUseCase

    /**
     * Binds the `GetAllFavoriteSongsUseCaseImpl` implementation to the `GetAllFavoriteSongsUseCase` interface.
     */
    @Binds
    @ViewModelScoped
    abstract fun bindGetAllFavoriteSongsUseCase(
        getAllFavoriteSongsUseCaseImpl: GetAllFavoriteSongsUseCaseImpl
    ): GetAllFavoriteSongsUseCase

    /**
     * Binds the `GetFavoriteSongWithIdUseCaseImpl` implementation to the `GetFavoriteSongWithIdUseCase` interface.
     */
    @Binds
    @ViewModelScoped
    abstract fun bindGetFavoriteSongWitIdUseCase(
        getFavoriteSongWithIdUseCaseImpl: GetFavoriteSongWithIdUseCaseImpl
    ): GetFavoriteSongWithIdUseCase

    /**
     * Binds the `GetAllGenresOfMusicUseCaseImpl` implementation to the `GetAllGenresOfMusicUseCase` interface.
     */
    @Binds
    @ViewModelScoped
    abstract fun bindGetAllGenresOfMusicUseCase(
        getAllGenresOfMusicUseCaseImpl: GetAllGenresOfMusicUseCaseImpl
    ): GetAllGenresOfMusicUseCase

    /**
     * Binds the `GetGenreArtistsWithGenreIdUseCaseImpl` implementation to the `GetGenreArtistsWithGenreIdUseCase` interface.
     */
    @Binds
    @ViewModelScoped
    abstract fun bingGetGenreArtistsWithGenreIdUseCase(
        getGenreArtistsWithGenreIdUseCaseImpl: GetGenreArtistsWithGenreIdUseCaseImpl
    ): GetGenreArtistsWithGenreIdUseCase

    /**
     * Binds the `GetArtistWithArtistIdUseCaseImpl` implementation to the `GetArtistWithArtistIdUseCase` interface.
     */
    @Binds
    @ViewModelScoped
    abstract fun bindGetArtistWithArtistIdUseCase(
        getArtistWithArtistIdUseCaseImpl: GetArtistWithArtistIdUseCaseImpl
    ): GetArtistWithArtistIdUseCase

    /**
     * Binds the `GetArtistAlbumsWithArtistIdUseCaseImpl` implementation to the `GetArtistAlbumsWithArtistIdUseCase` interface.
     */
    @Binds
    @ViewModelScoped
    abstract fun bindGetArtistAlbumsWithArtistIdUseCase(
        getArtistAlbumsWithArtistIdUseCaseImpl: GetArtistAlbumsWithArtistIdUseCaseImpl
    ): GetArtistAlbumsWithArtistIdUseCase

    /**
     * Binds the `GetAlbumTracksWithAlbumIdUseCaseImpl` implementation to the `GetAlbumTracksWithAlbumIdUseCase` interface.
     */
    @Binds
    @ViewModelScoped
    abstract fun bindGetAlbumTracksWithAlbumIdUseCase(
        getAlbumTracksWithAlbumIdUseCaseImpl: GetAlbumTracksWithAlbumIdUseCaseImpl
    ): GetAlbumTracksWithAlbumIdUseCase
}
