package ir.android.musicmanager.search

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import ir.android.musicmanager.R
import ir.android.musicmanager.pojos.search.Artist
import kotlinx.android.synthetic.main.album_item.view.*

/**
 * Created by  Roxa on 5/11/2019.
 */
class SearchAdapter(topArtistList: List<Artist>, clickHandler: ClickHandler) :

    RecyclerView.Adapter<SearchAdapter.TopArtistsViewHolder>() {

    val topArtistList = topArtistList
    val clickHandler = clickHandler

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopArtistsViewHolder {

        val v = LayoutInflater.from(parent.context).inflate(R.layout.album_item, parent, false)
        val viewHoler = TopArtistsViewHolder(v, clickHandler, parent.context)
        return viewHoler
    }

    override fun onBindViewHolder(holder: TopArtistsViewHolder, position: Int) {
        holder.bindItems(topArtistList[position])
    }

    override fun getItemCount() = topArtistList.size
    class TopArtistsViewHolder(val view: View, val clickHandler: ClickHandler, val context: Context) :
        RecyclerView.ViewHolder(view) {

        fun bindItems(searchResult: Artist) {
            view.btn_delete.visibility = View.INVISIBLE
            view.btn_add.visibility = View.INVISIBLE
            view.txt_album_artist.text = searchResult.name
            view.txt_album_name.text = searchResult.name

            if (searchResult.image[2].text.isNotEmpty())
                Picasso.with(context).load(searchResult.image[2].text).into(view.img_album)

            view.setOnClickListener {
                clickHandler.onClick(it)

            }
        }
    }

}
