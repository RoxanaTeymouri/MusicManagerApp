package ir.android.musicmanager.pojos.topAlbum

class AlbumDetailDataBase {
    var id: Int? = null
    var artistName: String? = null
    var albumName: String? = null
    var imageAlbum: String? = null

    constructor(artistName: String, albumName: String, imageAlbum: String) {
        this.artistName = artistName
        this.albumName = albumName
        this.imageAlbum = imageAlbum
    }

    constructor()

}

