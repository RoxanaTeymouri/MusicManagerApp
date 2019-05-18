package ir.android.musicmanager.archive

import ir.android.musicmanager.topalbum.DataBaseHelper

class ArchiveAlbumModel(private val presenter: ArchiveAlbumContract.Presenter) {

    fun fetchMusicAlbumList(db:DataBaseHelper) {

        val list =  db.getAllAlbums()
        presenter.getArchiveList(list)

    }


}

