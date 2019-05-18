package ir.android.musicmanager.pojos.search

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by  Roxa on 5/15/2019.
 */


data class Result(@SerializedName("opensearch:Query") val query:OpensearchQuery,
                  @SerializedName("opensearch:totalResults") val totalResults:String,
                  @SerializedName("opensearch:startIndex") val startIndex:String,
                  @SerializedName("opensearch:itemsPerPage") val itemsPerPage:String,
                  @SerializedName("artistmatches") val artistmatches:Artistmatches,
                  @SerializedName("@attr") val  attr:Attr
)

