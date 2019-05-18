package ir.android.musicmanager.archive.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import ir.android.musicmanager.R
import ir.android.musicmanager.pojos.topAlbum.AlbumDetailDataBase
import ir.android.musicmanager.utils.SaveImage
import kotlinx.android.synthetic.main.album_item.view.*


class ArchiveAlbumAdapter(
    val archiveAlbumList: List<AlbumDetailDataBase>,
    clickHandler: ir.android.musicmanager.topalbum.ClickHandler
) :
    RecyclerView.Adapter<ArchiveAlbumAdapter.ArchiveAlbumsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArchiveAlbumsViewHolder {

        val v = LayoutInflater.from(parent.context).inflate(R.layout.album_item, parent, false)
        val viewHoler = ArchiveAlbumsViewHolder(v, parent.context)
        return viewHoler
    }

    override fun onBindViewHolder(holder: ArchiveAlbumsViewHolder, position: Int) {
        holder.bindItems(archiveAlbumList[position])
    }

    override fun getItemCount() = archiveAlbumList.size


    class ArchiveAlbumsViewHolder(
        val view: View,
        val context: Context
    ) :
        RecyclerView.ViewHolder(view) {

        fun bindItems(albumDetailDataBase: AlbumDetailDataBase) {
            view.btn_delete.visibility = View.INVISIBLE
            view.btn_add.visibility = View.INVISIBLE
            view.txt_album_artist.text = albumDetailDataBase.artistName
            view.txt_album_name.text = albumDetailDataBase.albumName
            if (albumDetailDataBase?.imageAlbum?.isNotEmpty()!!) {
                Picasso.with(context).load(albumDetailDataBase.imageAlbum).into(view.img_album)
            }

        }
    }
}
