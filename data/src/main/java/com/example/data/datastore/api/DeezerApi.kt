package com.example.data.datastore.api

import com.example.data.dto.albumTracks.AlbumTracksResponse
import com.example.data.dto.artistAlbums.ArtistAlbumsResponse
import com.example.data.dto.artist.ArtistResponse
import com.example.data.dto.genreArtists.GenreArtistsResponse
import com.example.data.dto.genre.MusicGenreResponse
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * **DeezerApi**  
 * An interface defining API operations for interacting with the Deezer music service.  
 * This interface uses Retrofit annotations to specify HTTP requests and their endpoints.
 */
interface DeezerApi {

    /**
     * Fetches all available music genres from the Deezer API.
     *
     * @return A [MusicGenreResponse] object containing the list of music genres.
     *
     * Example Usage:
     * ```kotlin
     * val genres = deezerApi.getGenresOfMusic()
     * ```
     */
    @GET("genre")
    suspend fun getGenresOfMusic(): MusicGenreResponse

    /**
     * Fetches artists associated with a specific music genre.
     *
     * @param genre_id The ID of the genre for which artists need to be retrieved.
     * @return A [GenreArtistsResponse] object containing the list of artists in the genre.
     *
     * Example Usage:
     * ```kotlin
     * val genreArtists = deezerApi.getGenreArtistsWithGenreId(genreId = 5)
     * ```
     */
    @GET("genre/{genre_id}/artists")
    suspend fun getGenreArtistsWithGenreId(
        @Path("genre_id") genre_id: Int, // Genre ID used to filter artists.
    ): GenreArtistsResponse

    /**
     * Fetches details of a specific artist using their unique ID.
     *
     * @param artist_id The ID of the artist to retrieve.
     * @return An [ArtistResponse] object containing the artist's details.
     *
     * Example Usage:
     * ```kotlin
     * val artistDetails = deezerApi.getArtistWithArtistId(artistId = 12345)
     * ```
     */
    @GET("artist/{artist_id}")
    suspend fun getArtistWithArtistId(
        @Path("artist_id") artist_id: Int, // Artist ID to fetch details for.
    ): ArtistResponse

    /**
     * Fetches albums of a specific artist using their unique ID.
     *
     * @param artist_id The ID of the artist whose albums need to be retrieved.
     * @return An [ArtistAlbumsResponse] object containing the list of albums by the artist.
     *
     * Example Usage:
     * ```kotlin
     * val artistAlbums = deezerApi.getArtistAlbumsWithArtistId(artistId = 67890)
     * ```
     */
    @GET("artist/{artist_id}/albums")
    suspend fun getArtistAlbumsWithArtistId(
        @Path("artist_id") artist_id: Int, // Artist ID to fetch albums for.
    ): ArtistAlbumsResponse

    /**
     * Fetches tracks of a specific album using the album's unique ID.
     *
     * @param album_id The ID of the album whose tracks need to be retrieved.
     * @return An [AlbumTracksResponse] object containing the list of tracks in the album.
     *
     * Example Usage:
     * ```kotlin
     * val albumTracks = deezerApi.getAlbumTracksWithAlbumId(albumId = 34567)
     * ```
     */
    @GET("album/{album_id}/tracks")
    suspend fun getAlbumTracksWithAlbumId(
        @Path("album_id") albumId: Int, // Album ID to fetch tracks for.
    ): AlbumTracksResponse
}
