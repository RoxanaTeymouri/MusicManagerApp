package ir.android.musicmanager.topalbum

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import ir.android.musicmanager.pojos.topAlbum.Album
import ir.android.musicmanager.pojos.topAlbum.AlbumDetailDataBase
import kotlinx.android.synthetic.main.album_item.view.*

import android.net.Uri
import com.squareup.picasso.Picasso
import ir.android.musicmanager.R
import ir.android.musicmanager.utils.SaveImage


@Suppress("DEPRECATION")
/**
 * Created by  Roxa on 5/11/2019.
 */
class TopAlbumsAdapter(val topAlbumList: List<Album>, clickHandler: ClickHandler) :
    RecyclerView.Adapter<TopAlbumsAdapter.TopAlbumsViewHolder>() {
    val clickHandler = clickHandler
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopAlbumsViewHolder {

        val v = LayoutInflater.from(parent.context).inflate(R.layout.album_item, parent, false)
        val viewHoler = TopAlbumsViewHolder(v, clickHandler, parent.context)
        return viewHoler
    }

    override fun onBindViewHolder(holder: TopAlbumsViewHolder, position: Int) {
        holder.bindItems(topAlbumList[position])
    }

    override fun getItemCount() = topAlbumList.size


    class TopAlbumsViewHolder(val view: View, val clickHandler: ClickHandler, val context: Context) :
        RecyclerView.ViewHolder(view) {

        fun bindItems(imdb: Album) {

            view.txt_album_artist.text = imdb.artist.name
            view.txt_album_name.text = imdb.name

            if (imdb.image[2].text.isNotEmpty()) {
                Picasso.with(context).load(imdb.image[2].text).into(view.img_album)

            }


            view.setOnClickListener {
                val url = imdb.url
                val i = Intent(Intent.ACTION_VIEW)
                i.data = Uri.parse(url)
                context.startActivity(i)

            }

            view.btn_add.setOnClickListener {
                val dbHandler = DataBaseHelper(context, null)
                val albums = AlbumDetailDataBase(imdb.artist.name, imdb.name, imdb.image[2].text)
                dbHandler.addAlbum(albums)
                Toast.makeText(context, " Add to Archive ", Toast.LENGTH_SHORT).show()
            }
            view.btn_delete.setOnClickListener {
                val dbHandler = DataBaseHelper(context, null)
                dbHandler.deleteAlbums()
                Toast.makeText(context, " Delete from Archive ", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
