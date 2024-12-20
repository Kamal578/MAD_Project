package com.example.data.dto.artistAlbums

import com.google.gson.annotations.SerializedName

/**
 * **ArtistAlbumsData**  
 * A data transfer object (DTO) representing the details of an album by an artist.  
 * This class is used to parse and map JSON responses from the Deezer API for artist albums.
 *
 * @property id The unique identifier of the album.
 * @property title The title of the album.
 * @property link The URL link to the album on Deezer.
 * @property cover The URL to the default cover image of the album.
 * @property coverSmall The URL to a small-sized version of the album cover.
 * @property coverMedium The URL to a medium-sized version of the album cover.
 * @property coverBig The URL to a large-sized version of the album cover.
 * @property coverXl The URL to an extra-large version of the album cover.
 * @property md5Image The MD5 hash of the album's cover image.
 * @property genreId The genre ID associated with the album.
 * @property fans The number of fans who like the album.
 * @property releaseDate The release date of the album in string format.
 * @property recordType The type of recording (e.g., "album", "single").
 * @property tracklist The URL to the list of tracks in the album.
 * @property explicitLyrics A flag indicating whether the album contains explicit lyrics.
 * @property type The type of the object, typically "album".
 */
data class ArtistAlbumsData(

    @SerializedName("id")
    var id: Int,

    @SerializedName("title")
    var title: String,

    @SerializedName("link")
    var link: String,

    @SerializedName("cover")
    var cover: String,

    @SerializedName("cover_small")
    var coverSmall: String,

    @SerializedName("cover_medium")
    var coverMedium: String,

    @SerializedName("cover_big")
    var coverBig: String,

    @SerializedName("cover_xl")
    var coverXl: String,

    @SerializedName("md5_image")
    var md5Image: String,

    @SerializedName("genre_id")
    var genreId: Int,

    @SerializedName("fans")
    var fans: Int,

    @SerializedName("release_date")
    var releaseDate: String,

    @SerializedName("record_type")
    var recordType: String,

    @SerializedName("tracklist")
    var tracklist: String,

    @SerializedName("explicit_lyrics")
    var explicitLyrics: Boolean,

    @SerializedName("type")
    var type: String,
)