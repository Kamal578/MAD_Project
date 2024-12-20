package com.example.data.repository

import com.example.common.ResponseResult
import com.example.data.di.coroutine.IoDispatcher
import com.example.data.mapper.*
import com.example.data.source.local.LocalDataSource
import com.example.data.source.remote.RemoteDataSource
import com.example.data.util.toDomain
import com.example.domain.entity.*
import com.example.domain.repository.DeezerRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * **DeezerRepositoryImpl**  
 * The implementation of the `DeezerRepository` interface.  
 * This class acts as a mediator between the data sources (local and remote) and the domain layer, 
 * performing data transformations and ensuring clean separation of concerns.
 */
class DeezerRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val favoriteMapperEtoDb: FavoriteMapperEtoDb,
    private val favoriteMapperDbtoE: FavoriteMapperDbtoE,
    private val favoritesListMapper: FavoritesListMapper,
    private val musicGenreListMapper: MusicGenreListMapper,
    private val genreArtistListMapper: GenreArtistListMapper,
    private val artistMapper: ArtistMapper,
    private val artistAlbumsListMapper: ArtistAlbumsListMapper,
    private val albumTracksListMapper: AlbumTracksListMapper,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO,
) : DeezerRepository {

    /**
     * Adds a song to the favorites list in the local database.
     *
     * @param favoritesEntity The `FavoritesEntity` representing the song.
     * @return A `ResponseResult` containing the added song as a `FavoritesEntity`.
     */
    override suspend fun addSongToFavorites(favoritesEntity: FavoritesEntity): ResponseResult<FavoritesEntity> {
        return withContext(ioDispatcher) {
            val result = localDataSource.addSongToFavorites(favoriteMapperEtoDb.map(favoritesEntity))
            result.toDomain(favoriteMapperDbtoE)
        }
    }

    /**
     * Retrieves all favorite songs from the local database.
     *
     * @return A `ResponseResult` containing a list of `FavoritesEntity`.
     */
    override suspend fun getAllFavoriteSongs(): ResponseResult<List<FavoritesEntity>> {
        return withContext(ioDispatcher) {
            val result = localDataSource.getAllFavoriteSongs()
            result.toDomain(favoritesListMapper)
        }
    }

    /**
     * Deletes a song from the favorites list in the local database.
     *
     * @param favoritesEntity The `FavoritesEntity` representing the song.
     * @return A `ResponseResult` containing the deleted song as a `FavoritesEntity`.
     */
    override suspend fun deleteSongToFavorites(favoritesEntity: FavoritesEntity): ResponseResult<FavoritesEntity> {
        return withContext(ioDispatcher) {
            val result = localDataSource.deleteSongToFavorites(favoriteMapperEtoDb.map(favoritesEntity))
            result.toDomain(favoriteMapperDbtoE)
        }
    }

    /**
     * Retrieves a specific favorite song by its ID from the local database.
     *
     * @param id The ID of the favorite song.
     * @return A `ResponseResult` containing the `FavoritesEntity`.
     */
    override suspend fun getFavoriteSongWithId(id: Int): ResponseResult<FavoritesEntity> {
        return withContext(ioDispatcher) {
            val result = localDataSource.getFavoriteSongWithId(id)
            result.toDomain(favoriteMapperDbtoE)
        }
    }

    /**
     * Retrieves all music genres from the Deezer API.
     *
     * @return A `ResponseResult` containing a list of `MusicGenreEntity`.
     */
    override suspend fun getAllGenresOfMusic(): ResponseResult<List<MusicGenreEntity>> {
        return withContext(ioDispatcher) {
            val response = remoteDataSource.getAllGenresOfMusic()
            response.toDomain(musicGenreListMapper)
        }
    }

    /**
     * Retrieves artists of a specific genre from the Deezer API.
     *
     * @param genreId The ID of the genre.
     * @return A `ResponseResult` containing a list of `GenreArtistsEntity`.
     */
    override suspend fun getGenreArtistsWithGenreId(genreId: Int): ResponseResult<List<GenreArtistsEntity>> {
        return withContext(ioDispatcher) {
            val response = remoteDataSource.getGenreArtistsWithGenreId(genreId)
            response.toDomain(genreArtistListMapper)
        }
    }

    /**
     * Retrieves details of an artist by their ID from the Deezer API.
     *
     * @param artistId The ID of the artist.
     * @return A `ResponseResult` containing the `ArtistEntity`.
     */
    override suspend fun getArtistWithArtistId(artistId: Int): ResponseResult<ArtistEntity> {
        return withContext(ioDispatcher) {
            val response = remoteDataSource.getArtistWithArtistId(artistId)
            response.toDomain(artistMapper)
        }
    }

    /**
     * Retrieves albums of a specific artist by their ID from the Deezer API.
     *
     * @param artistId The ID of the artist.
     * @return A `ResponseResult` containing a list of `ArtistAlbumsEntity`.
     */
    override suspend fun getArtistAlbumsWithArtistId(artistId: Int): ResponseResult<List<ArtistAlbumsEntity>> {
        return withContext(ioDispatcher) {
            val response = remoteDataSource.getArtistAlbumsWithArtistId(artistId)
            response.toDomain(artistAlbumsListMapper)
        }
    }

    /**
     * Retrieves tracks of a specific album by its ID from the Deezer API.
     *
     * @param albumId The ID of the album.
     * @return A `ResponseResult` containing a list of `AlbumTracksEntity`.
     */
    override suspend fun getAlbumTracksWithAlbumId(albumId: Int): ResponseResult<List<AlbumTracksEntity>> {
        return withContext(ioDispatcher) {
            val response = remoteDataSource.getAlbumTracksWithAlbumId(albumId)
            response.toDomain(albumTracksListMapper)
        }
    }
}
