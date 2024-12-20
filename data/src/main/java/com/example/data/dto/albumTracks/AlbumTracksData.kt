package com.example.data.dto.albumTracks

import com.google.gson.annotations.SerializedName

/**
 * **AlbumTracksData**  
 * A data transfer object (DTO) representing the details of a track in an album.  
 * This class is used to parse and map JSON responses from the Deezer API.
 *
 * @property id The unique identifier for the track.
 * @property readable A flag indicating whether the track is readable/playable.
 * @property title The full title of the track.
 * @property titleShort A shortened version of the track's title.
 * @property titleVersion The version of the track (e.g., remix or live version).
 * @property isrc The International Standard Recording Code (ISRC) for the track.
 * @property link The URL link to the track on Deezer.
 * @property duration The duration of the track in seconds.
 * @property trackPosition The track's position in the album.
 * @property diskNumber The disk number for multi-disk albums.
 * @property rank The popularity rank of the track.
 * @property explicitLyrics A flag indicating whether the track contains explicit lyrics.
 * @property explicitContentLyrics A numerical rating for explicit lyrical content.
 * @property explicitContentCover A numerical rating for explicit cover art.
 * @property preview The URL link to a short preview of the track.
 * @property md5Image The MD5 hash of the track's album cover image.
 * @property artist An `Artist` object representing the track's artist.
 * @property type The type of this object, typically "track".
 */
data class AlbumTracksData(

    @SerializedName("id") 
    var id: Int,

    @SerializedName("readable") 
    var readable: Boolean,

    @SerializedName("title") 
    var title: String,

    @SerializedName("title_short") 
    var titleShort: String,

    @SerializedName("title_version") 
    var titleVersion: String,

    @SerializedName("isrc") 
    var isrc: String,

    @SerializedName("link") 
    var link: String,

    @SerializedName("duration") 
    var duration: Int,

    @SerializedName("track_position") 
    var trackPosition: Int,

    @SerializedName("disk_number") 
    var diskNumber: Int,

    @SerializedName("rank") 
    var rank: Int,

    @SerializedName("explicit_lyrics") 
    var explicitLyrics: Boolean,

    @SerializedName("explicit_content_lyrics") 
    var explicitContentLyrics: Int,

    @SerializedName("explicit_content_cover") 
    var explicitContentCover: Int,

    @SerializedName("preview") 
    var preview: String,

    @SerializedName("md5_image") 
    var md5Image: String,

    @SerializedName("artist") 
    var artist: Artist,

    @SerializedName("type") 
    var type: String
)
