package ir.android.musicmanager.search

import ir.android.musicmanager.pojos.search.Artist

/**
 * Created by  Roxa on 5/11/2019.
 */


interface SearchContract {

    interface View {
        fun showResultSearch(list: List<Artist>)
    }

    interface Presenter {
        fun sentDataForServer(artistName: String, apiKey: String)
        fun getResultSearch(list: List<Artist>)
      }


}