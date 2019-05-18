package ir.android.musicmanager.topalbum

import ir.android.musicmanager.pojos.topAlbum.IMDB

/**
 * Created by  Roxa on 5/11/2019.
 */


class TopAlbumsPresenter(private val view: TopAlbumsContract.View) : TopAlbumsContract.Presenter {

    var mTopAlbumModel = TopAlbumModel(this)

    override fun getTopAlbums(list: IMDB?) {
        view.showAlbum(list)
    }
    override fun sentDataForServer(artistName: String) {
        mTopAlbumModel.fetchDataAlbum(artistName)
    }


}


