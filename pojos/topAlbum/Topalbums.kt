package ir.android.musicmanager.pojos.topAlbum

import com.google.gson.annotations.SerializedName

data class Topalbums(@SerializedName("album") var album: List<Album>, @SerializedName("@attr") var attr: Attr)
