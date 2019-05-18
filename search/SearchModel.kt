package ir.android.musicmanager.search

import android.util.Log
import ir.android.musicmanager.pojos.search.SearchResult
import ir.android.musicmanager.utils.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by  Roxa on 5/14/2019.
 */

class SearchModel(private val presenter: SearchContract.Presenter) {

    fun fetchDataAlbum(artistName: String) {


        val retrofit = Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        var apiService = retrofit.create(RetrofitServiceGenerator::class.java)
        var call = apiService.getTopAlbum(artistName, Constants.API_KEY)


        Log.d("REQUEST", call.toString() + "")
        call.enqueue(object : Callback<SearchResult> {
            override fun onResponse(call: Call<SearchResult>, response: retrofit2.Response<SearchResult>?) {



                if (response != null) {
                    presenter.getResultSearch(response.body()!!.results.artistmatches.artist)
                }
            }

            override fun onFailure(call: Call<SearchResult>, t: Throwable) {

            }
        })
    }
}