package ir.android.musicmanager.pojos.topAlbum

class AlbumDetailDataBase {
    var id: Int? = null
    var artistName: String? = null
    var albumName: String? = null
    var mbid: String? = null

    constructor(artistName: String, albumName: String, mbid: String) {
        this.artistName = artistName
        this.albumName = albumName
        this.mbid = mbid
    }
    constructor()
}

