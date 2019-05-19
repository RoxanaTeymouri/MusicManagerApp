package ir.android.musicmanager.archive

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ir.android.musicmanager.R
import ir.android.musicmanager.archive.adapter.ArchiveAlbumAdapter
import ir.android.musicmanager.base.BaseFragment
import ir.android.musicmanager.pojos.topAlbum.AlbumDetailDataBase
import ir.android.musicmanager.topalbum.ClickHandler
import ir.android.musicmanager.topalbum.DataBaseHelper
import kotlinx.android.synthetic.main.fragment_archive.view.*
import kotlinx.android.synthetic.main.fragment_top_albums.view.*

@Suppress("UNREACHABLE_CODE")
/**
 * Created by  Roxa on 5/10/2019.
 */

class ArchiveAlbumFragment : BaseFragment(), ArchiveAlbumContract.View {

    companion object {
        private var instance: ArchiveAlbumFragment? = null
        fun newInstance(): ArchiveAlbumFragment? {

            if (instance == null)
                instance = ArchiveAlbumFragment()
            return instance
        }
    }

    val presenter = ArchiveAlbumPresenter(this)
    lateinit var rootView: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_archive, container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val db = DataBaseHelper(context, null)
        presenter.showAlbumsList(db)
    }

    override fun showArchiveList(list: List<AlbumDetailDataBase>) {
        initRecyclerView(list)
    }

    private fun initRecyclerView(list: List<AlbumDetailDataBase>) {
        //set adapter
        val adapter = ArchiveAlbumAdapter(list, object : ClickHandler {
            override fun onClick(v: View) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })
        rootView.recyclerView_archive.adapter = adapter
        rootView.recyclerView_archive.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)

    }
}