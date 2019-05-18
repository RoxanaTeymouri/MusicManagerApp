package ir.android.musicmanager.pojos.search

import com.google.gson.annotations.SerializedName

/**
 * Created by  Roxa on 5/15/2019.
 */


data class Image(@SerializedName("#text") val text: String, @SerializedName("size") val size: String)

