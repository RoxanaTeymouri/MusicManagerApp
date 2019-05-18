package ir.android.musicmanager.pojos.topAlbum

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


data class Album(
    @SerializedName("name") var name: String,
    @SerializedName("playcount") var playcount: Int,
    @SerializedName("mbid") var mbid: String,
    @SerializedName("url") var url: String,
    @SerializedName("artist") var artist: Artist,
    @SerializedName("image") var image: List<Image>
)