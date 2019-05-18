package ir.android.musicmanager.topalbum

import android.util.Log
import ir.android.musicmanager.pojos.topAlbum.IMDB
import ir.android.musicmanager.utils.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * Created by  Roxa on 5/14/2019.
 */

class TopAlbumModel(private val presenter: TopAlbumsContract.Presenter){

    fun fetchDataAlbum(artistName: String) {

        val retrofit = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        var apiService = retrofit.create(RetrofitServiceGenerator::class.java)
        var call = apiService.getTopAlbum(artistName, Constants.API_KEY)


        Log.d("REQUEST", call.toString() + "")
        call.enqueue(object : Callback<IMDB> {
            override fun onFailure(call: Call<IMDB>, t: Throwable) {
                Log.d("REQUEST FAIL", t.message)
            }

            override fun onResponse(call: Call<IMDB>, response: Response<IMDB>) {
                presenter.getTopAlbums(response.body())
            }
        })
    }

}