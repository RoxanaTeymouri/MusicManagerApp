package ir.android.musicmanager

import android.os.Bundle
import ir.android.musicmanager.base.BaseActivity
import kotlinx.android.synthetic.main.album_item.*
import android.content.Intent


class AlbumDetailActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.album_detail)
        init()
    }

    private fun init() {
        val intent = intent
        val albumName = intent.getStringExtra("AlbumName")
        val artistName = intent.getStringExtra("ArtistName")

        txt_album_artist.text=artistName
        txt_album_name.text=albumName
    }
}