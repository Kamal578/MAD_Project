package com.example.domain.repository

import com.example.common.ResponseResult
import com.example.domain.entity.*

/**
 * **DeezerRepository**  
 * Repository interface for accessing Deezer data.  
 * This interface defines the contract for data operations, providing an abstraction for interacting with the data layer.
 */
interface DeezerRepository {

    /**
     * Adds a song to the favorites list.
     *
     * @param favoritesEntity The `FavoritesEntity` representing the song to be added.
     * @return A `ResponseResult` containing the added `FavoritesEntity` if successful, or an error otherwise.
     */
    suspend fun addSongToFavorites(favoritesEntity: FavoritesEntity): ResponseResult<FavoritesEntity>

    /**
     * Retrieves all songs in the favorites list.
     *
     * @return A `ResponseResult` containing a list of `FavoritesEntity` if successful, or an error otherwise.
     */
    suspend fun getAllFavoriteSongs(): ResponseResult<List<FavoritesEntity>>

    /**
     * Deletes a song from the favorites list.
     *
     * @param favoritesEntity The `FavoritesEntity` representing the song to be deleted.
     * @return A `ResponseResult` containing the deleted `FavoritesEntity` if successful, or an error otherwise.
     */
    suspend fun deleteSongToFavorites(favoritesEntity: FavoritesEntity): ResponseResult<FavoritesEntity>

    /**
     * Retrieves a specific favorite song by its ID.
     *
     * @param id The unique ID of the favorite song.
     * @return A `ResponseResult` containing the `FavoritesEntity` if successful, or an error otherwise.
     */
    suspend fun getFavoriteSongWithId(id: Int): ResponseResult<FavoritesEntity>

    /**
     * Retrieves all music genres from the Deezer API.
     *
     * @return A `ResponseResult` containing a list of `MusicGenreEntity` if successful, or an error otherwise.
     */
    suspend fun getAllGenresOfMusic(): ResponseResult<List<MusicGenreEntity>>

    /**
     * Retrieves artists associated with a specific music genre.
     *
     * @param genreId The unique ID of the music genre.
     * @return A `ResponseResult` containing a list of `GenreArtistsEntity` if successful, or an error otherwise.
     */
    suspend fun getGenreArtistsWithGenreId(genreId: Int): ResponseResult<List<GenreArtistsEntity>>

    /**
     * Retrieves details of a specific artist by their ID.
     *
     * @param artistId The unique ID of the artist.
     * @return A `ResponseResult` containing the `ArtistEntity` if successful, or an error otherwise.
     */
    suspend fun getArtistWithArtistId(artistId: Int): ResponseResult<ArtistEntity>

    /**
     * Retrieves albums of a specific artist by their ID.
     *
     * @param artistId The unique ID of the artist.
     * @return A `ResponseResult` containing a list of `ArtistAlbumsEntity` if successful, or an error otherwise.
     */
    suspend fun getArtistAlbumsWithArtistId(artistId: Int): ResponseResult<List<ArtistAlbumsEntity>>

    /**
     * Retrieves tracks of a specific album by its ID.
     *
     * @param albumId The unique ID of the album.
     * @return A `ResponseResult` containing a list of `AlbumTracksEntity` if successful, or an error otherwise.
     */
    suspend fun getAlbumTracksWithAlbumId(albumId: Int): ResponseResult<List<AlbumTracksEntity>>
}
