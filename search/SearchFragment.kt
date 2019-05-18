package ir.android.musicmanager.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ir.android.musicmanager.R
import ir.android.musicmanager.base.BaseFragment
import ir.android.musicmanager.pojos.search.Artist
import ir.android.musicmanager.utils.Constants
import kotlinx.android.synthetic.main.fragment_archive.view.*
import kotlinx.android.synthetic.main.fragment_search.*


/**
 * Created by  Roxa on 5/10/2019.
 */

class SearchFragment : BaseFragment(), SearchContract.View {


    companion object {
        private var instance: SearchFragment? = null
        fun newInstance(): SearchFragment? {
            if (instance == null)
                instance = SearchFragment()

            return instance
        }
    }


    val presenter = SearchPresenter(this)
    lateinit var rootView: View


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_search, container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        btnSearch.setOnClickListener {
            presenter.sentDataForServer(edtName.text.toString(), Constants.API_KEY)

        }

    }

    override fun showResultSearch(list: List<Artist>) {
        initRecyclerView(list)
    }


    private fun init() {


    }

    private fun initRecyclerView(list: List<Artist>) {

        //set adapter
        val adapter = SearchAdapter(list, object : ClickHandler {
            override fun onClick(v: View) {
                // presenter.onRecyclerViewItemClick(v)
            }
        })


        rootView.recyclerView_archive.adapter = adapter
        rootView.recyclerView_archive.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)

    }
}
