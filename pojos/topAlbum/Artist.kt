package ir.android.musicmanager.pojos.topAlbum

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Artist(@SerializedName("name") var name: String, @SerializedName("mbid") var mbid: String,
                  @SerializedName("url") var url: String)
