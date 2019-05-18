package ir.android.musicmanager.topalbum

import ir.android.musicmanager.pojos.topAlbum.IMDB

/**
 * Created by  Roxa on 5/11/2019.
 */


interface TopAlbumsContract {
    interface View {
        fun showAlbum(list: IMDB?)
    }

    interface Presenter {
        fun sentDataForServer(artistName: String)
        fun getTopAlbums(list: IMDB?)

    }


}