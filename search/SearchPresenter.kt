package ir.android.musicmanager.search

import ir.android.musicmanager.pojos.search.Artist

/**
 * Created by  Roxa on 5/11/2019.
 */

class SearchPresenter(private val view: SearchContract.View) : SearchContract.Presenter {

    val mTopAlbumModel = SearchModel(this)
    override fun getResultSearch(list: List<Artist>) {
        view.showResultSearch(list)
    }

    override fun sentDataForServer(artistName: String, apiKey: String) {
        mTopAlbumModel.fetchDataAlbum(artistName)
    }
}


