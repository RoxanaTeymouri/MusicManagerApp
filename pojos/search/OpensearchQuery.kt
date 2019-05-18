package ir.android.musicmanager.pojos.search

import com.google.gson.annotations.SerializedName

/**
 * Created by  Roxa on 5/15/2019.
 */

data class OpensearchQuery(@SerializedName("#text") val text: String, @SerializedName("role") val role: String,
                           @SerializedName("searchTerms") val searchTerms: String, @SerializedName("startPage") val startPage: String)