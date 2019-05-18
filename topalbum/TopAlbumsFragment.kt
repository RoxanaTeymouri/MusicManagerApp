package ir.android.musicmanager.topalbum

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ir.android.musicmanager.base.BaseFragment
import ir.android.musicmanager.pojos.topAlbum.IMDB
import kotlinx.android.synthetic.main.fragment_top_albums.*
import kotlinx.android.synthetic.main.fragment_top_albums.view.*
import android.content.Intent
import ir.android.musicmanager.AlbumDetailActivity
import ir.android.musicmanager.R


@Suppress("UNREACHABLE_CODE")
/**
 * Created by  Roxa on 5/10/2019.
 */
class TopAlbumsFragment : BaseFragment(), TopAlbumsContract.View {

    companion object {
        private var instance: TopAlbumsFragment? = null
        fun newInstance(): TopAlbumsFragment? {

            if (instance == null)
                instance = TopAlbumsFragment()
            return instance
        }
    }

    val presenter = TopAlbumsPresenter(this)
    lateinit var rootView: View


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_top_albums, container, false)
        return rootView

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnSearch.setOnClickListener {
            presenter.sentDataForServer(edtName.text.toString())
        }
    }

    override fun showAlbum(list: IMDB?) {
        initRecyclerView(list)
    }

    private fun initRecyclerView(list: IMDB?) {

        //set adapter
        val adapter = TopAlbumsAdapter(list?.topalbums?.album.orEmpty(), object : ClickHandler {

            override fun onClick(v: View) {
            }
        })

        rootView.recyclerView_albums.adapter = adapter
        rootView.recyclerView_albums.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)

    }
}