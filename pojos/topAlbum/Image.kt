package ir.android.musicmanager.pojos.topAlbum

import com.google.gson.annotations.SerializedName

data class Image(@SerializedName("#text") var text: String, @SerializedName("size") var size: String)
