package ir.android.musicmanager.search

/**
 * Created by  Roxa on 5/10/2019.
 */

import ir.android.musicmanager.pojos.search.SearchResult
import ir.android.musicmanager.pojos.topAlbum.IMDB
import ir.android.musicmanager.pojos.topAlbum.Topalbums
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface RetrofitServiceGenerator {

    @GET("?method=artist.search&format=json")
    fun getTopAlbum(@Query("artist") artist: String, @Query("api_key") apiKey: String): Call<SearchResult>

}