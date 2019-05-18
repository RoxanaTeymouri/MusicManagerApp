package ir.android.musicmanager.pojos.topAlbum

import com.google.gson.annotations.SerializedName

data class Attr(@SerializedName("artist") var artist: String, @SerializedName("page") var page: String,
                @SerializedName("perPage") var perPage: String, @SerializedName("totalPages") var totalPages: String,
                @SerializedName("total") var total: String)
