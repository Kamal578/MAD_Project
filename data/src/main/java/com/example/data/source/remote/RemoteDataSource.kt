package com.example.data.source.remote

import com.example.common.ResponseResult
import com.example.data.dto.albumTracks.AlbumTracksData
import com.example.data.dto.artist.ArtistResponse
import com.example.data.dto.artistAlbums.ArtistAlbumsData
import com.example.data.dto.genre.MusicGenreData
import com.example.data.dto.genreArtists.GenreArtistsData

/**
 * **RemoteDataSource**  
 * Interface for the remote data source operations.  
 * This defines methods to interact with the Deezer API for retrieving music-related data.
 */
interface RemoteDataSource {

    /**
     * Retrieves all available music genres from the Deezer API.
     *
     * @return A `ResponseResult` containing a list of `MusicGenreData` if successful, or an error otherwise.
     */
    suspend fun getAllGenresOfMusic(): ResponseResult<List<MusicGenreData>>

    /**
     * Retrieves the list of artists for a specific genre from the Deezer API.
     *
     * @param genreId The unique ID of the genre for which the artists are to be retrieved.
     * @return A `ResponseResult` containing a list of `GenreArtistsData` if successful, or an error otherwise.
     */
    suspend fun getGenreArtistsWithGenreId(genreId: Int): ResponseResult<List<GenreArtistsData>>

    /**
     * Retrieves the details of an artist with a specific ID from the Deezer API.
     *
     * @param artistId The unique ID of the artist to be retrieved.
     * @return A `ResponseResult` containing an `ArtistResponse` if successful, or an error otherwise.
     */
    suspend fun getArtistWithArtistId(artistId: Int): ResponseResult<ArtistResponse>

    /**
     * Retrieves the list of albums for a specific artist from the Deezer API.
     *
     * @param artistId The unique ID of the artist whose albums are to be retrieved.
     * @return A `ResponseResult` containing a list of `ArtistAlbumsData` if successful, or an error otherwise.
     */
    suspend fun getArtistAlbumsWithArtistId(artistId: Int): ResponseResult<List<ArtistAlbumsData>>

    /**
     * Retrieves the list of tracks for a specific album from the Deezer API.
     *
     * @param albumId The unique ID of the album whose tracks are to be retrieved.
     * @return A `ResponseResult` containing a list of `AlbumTracksData` if successful, or an error otherwise.
     */
    suspend fun getAlbumTracksWithAlbumId(albumId: Int): ResponseResult<List<AlbumTracksData>>
}
