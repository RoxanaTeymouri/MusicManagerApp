package ir.android.musicmanager.archive

import ir.android.musicmanager.pojos.topAlbum.AlbumDetailDataBase

/**
 * Created by  Roxa on 5/10/2019.
 */

interface ArchiveAlbumContract {

    interface View {
        fun showArchiveList(list: List<AlbumDetailDataBase>)
    }

    interface Presenter {
        fun getArchiveList(list: List<AlbumDetailDataBase>)
    }
}
