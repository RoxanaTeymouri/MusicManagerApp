package ir.android.musicmanager.archive

import ir.android.musicmanager.pojos.topAlbum.AlbumDetailDataBase
import ir.android.musicmanager.topalbum.DataBaseHelper

/**
 * Created by  Roxa on 5/11/2019.
 */


class ArchiveAlbumPresenter(private val view: ArchiveAlbumContract.View) : ArchiveAlbumContract.Presenter {
    private val model = ArchiveAlbumModel(this)

    fun showAlbumsList(db: DataBaseHelper) {
        model.fetchMusicAlbumList(db)
    }

    override fun getArchiveList(list: List<AlbumDetailDataBase>) {
        view.showArchiveList(list)
    }
}


