package com.example.data.source.remote

import com.example.common.ResponseResult
import com.example.common.ResultError
import com.example.data.datastore.api.DeezerApi
import com.example.data.dto.albumTracks.AlbumTracksData
import com.example.data.dto.artist.ArtistResponse
import com.example.data.dto.artistAlbums.ArtistAlbumsData
import com.example.data.dto.genre.MusicGenreData
import com.example.data.dto.genreArtists.GenreArtistsData
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

/**
 * **RemoteDataSourceImpl**  
 * Implementation of the `RemoteDataSource` interface.  
 * This class performs API requests to the Deezer API and handles the response, mapping it into a `ResponseResult`.
 *
 * @property deezerApi An instance of `DeezerApi` for interacting with the Deezer API endpoints.
 */
class RemoteDataSourceImpl @Inject constructor(
    private val deezerApi: DeezerApi,
) : RemoteDataSource {

    /**
     * Retrieves all genres of music from the Deezer API.
     *
     * @return A `ResponseResult` containing a list of `MusicGenreData` if successful, or an error otherwise.
     */
    override suspend fun getAllGenresOfMusic(): ResponseResult<List<MusicGenreData>> {
        return try {
            val response = deezerApi.getGenresOfMusic()
            ResponseResult.Success(response.data) // Map API response to success result.
        } catch (e: IOException) {
            ResponseResult.Error.IOException(
                ResultError(errorMessage = e.localizedMessage ?: "An IO error occurred.")
            )
        } catch (e: HttpException) {
            ResponseResult.Error.ApiError(
                ResultError(errorMessage = e.localizedMessage ?: "An API error occurred.")
            )
        }
    }

    /**
     * Retrieves a list of artists for a specific genre from the Deezer API.
     *
     * @param genreId The unique ID of the genre.
     * @return A `ResponseResult` containing a list of `GenreArtistsData` if successful, or an error otherwise.
     */
    override suspend fun getGenreArtistsWithGenreId(genreId: Int): ResponseResult<List<GenreArtistsData>> {
        return try {
            val response = deezerApi.getGenreArtistsWithGenreId(genreId)
            ResponseResult.Success(response.data) // Map API response to success result.
        } catch (e: IOException) {
            ResponseResult.Error.IOException(
                ResultError(errorMessage = e.localizedMessage ?: "An IO error occurred.")
            )
        } catch (e: HttpException) {
            ResponseResult.Error.ApiError(
                ResultError(errorMessage = e.localizedMessage ?: "An API error occurred.")
            )
        }
    }

    /**
     * Retrieves the details of an artist by their ID from the Deezer API.
     *
     * @param artistId The unique ID of the artist.
     * @return A `ResponseResult` containing an `ArtistResponse` if successful, or an error otherwise.
     */
    override suspend fun getArtistWithArtistId(artistId: Int): ResponseResult<ArtistResponse> {
        return try {
            val response = deezerApi.getArtistWithArtistId(artistId)
            ResponseResult.Success(response) // Map API response to success result.
        } catch (e: IOException) {
            ResponseResult.Error.IOException(
                ResultError(errorMessage = e.localizedMessage ?: "An IO error occurred.")
            )
        } catch (e: HttpException) {
            ResponseResult.Error.ApiError(
                ResultError(errorMessage = e.localizedMessage ?: "An API error occurred.")
            )
        }
    }

    /**
     * Retrieves a list of albums for a specific artist from the Deezer API.
     *
     * @param artistId The unique ID of the artist.
     * @return A `ResponseResult` containing a list of `ArtistAlbumsData` if successful, or an error otherwise.
     */
    override suspend fun getArtistAlbumsWithArtistId(artistId: Int): ResponseResult<List<ArtistAlbumsData>> {
        return try {
            val response = deezerApi.getArtistAlbumsWithArtistId(artistId)
            ResponseResult.Success(response.data) // Map API response to success result.
        } catch (e: IOException) {
            ResponseResult.Error.IOException(
                ResultError(errorMessage = e.localizedMessage ?: "An IO error occurred.")
            )
        } catch (e: HttpException) {
            ResponseResult.Error.ApiError(
                ResultError(errorMessage = e.localizedMessage ?: "An API error occurred.")
            )
        }
    }

    /**
     * Retrieves a list of tracks for a specific album from the Deezer API.
     *
     * @param albumId The unique ID of the album.
     * @return A `ResponseResult` containing a list of `AlbumTracksData` if successful, or an error otherwise.
     */
    override suspend fun getAlbumTracksWithAlbumId(albumId: Int): ResponseResult<List<AlbumTracksData>> {
        return try {
            val response = deezerApi.getAlbumTracksWithAlbumId(albumId)
            ResponseResult.Success(response.data) // Map API response to success result.
        } catch (e: IOException) {
            ResponseResult.Error.IOException(
                ResultError(errorMessage = e.localizedMessage ?: "An IO error occurred.")
            )
        } catch (e: HttpException) {
            ResponseResult.Error.ApiError(
                ResultError(errorMessage = e.localizedMessage ?: "An API error occurred.")
            )
        }
    }
}
