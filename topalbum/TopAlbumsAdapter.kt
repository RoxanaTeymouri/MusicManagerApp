package ir.android.musicmanager.topalbum

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import ir.android.musicmanager.R
import ir.android.musicmanager.pojos.topAlbum.Album
import ir.android.musicmanager.pojos.topAlbum.AlbumDetailDataBase
import ir.android.musicmanager.utils.SaveImage
import kotlinx.android.synthetic.main.album_item.view.*


@Suppress("DEPRECATION")
/**
 * Created by  Roxa on 5/11/2019.
 */
class TopAlbumsAdapter(val topAlbumList: List<Album>, clickHandler: ClickHandler) :
    RecyclerView.Adapter<TopAlbumsAdapter.TopAlbumsViewHolder>(), ActivityCompat.OnRequestPermissionsResultCallback {

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
                // Picasso.with(context).load(imdb.image[2].text).into(SaveImage.getTarget(imdb.mbid))

            }


            view.setOnClickListener {
                val url = imdb.url
                val i = Intent(Intent.ACTION_VIEW)
                i.data = Uri.parse(url)
                context.startActivity(i)

            }

            view.btn_add.setOnClickListener {
                checkPermission()
                val dbHandler = DataBaseHelper(context, null)
                val albums = AlbumDetailDataBase(imdb.artist.name, imdb.name, imdb.artist.mbid)

                Picasso.with(context).load(imdb.image[2].text).into(SaveImage.getTarget(imdb.artist.mbid))
                dbHandler.addAlbum(albums)
                Toast.makeText(context, " Add to Archive ", Toast.LENGTH_SHORT).show()
            }
            view.btn_delete.setOnClickListener {
                checkPermission()
                val dbHandler = DataBaseHelper(context, null)
                dbHandler.deleteAlbums()
                Toast.makeText(context, " Delete from Archive ", Toast.LENGTH_SHORT).show()
            }
        }

        fun checkPermission() {

            val permission =
                ContextCompat.checkSelfPermission(context, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
            if (permission != PackageManager.PERMISSION_GRANTED) {
                makeRequest()
            }
        }

        fun makeRequest() {
            ActivityCompat.requestPermissions(
                context as Activity,
                arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE),
                1
            )
        }
    }


    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if (grantResults.isEmpty() || grantResults[0] != PackageManager.PERMISSION_GRANTED) {

            Log.d("permi", "errrrr")
        }
//        val listener = DialogInterface.OnClickListener { dialog, id -> finish() }
//
//        val builder = AlertDialog.Builder()
//        builder.setTitle("Digikala")
//            .setMessage("")
//            .setPositiveButton("" ,listener)
//            .show()


    }
}
