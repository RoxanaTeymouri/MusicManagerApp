package ir.android.musicmanager

import android.os.Bundle
import ir.android.musicmanager.archive.ArchiveAlbumFragment
import ir.android.musicmanager.base.BaseActivity
import ir.android.musicmanager.search.SearchFragment
import ir.android.musicmanager.topalbum.DataBaseHelper
import ir.android.musicmanager.topalbum.TopAlbumsFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNav.inflateMenu(R.menu.main_menu)

        val albumFragment = TopAlbumsFragment.newInstance()
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, albumFragment!!, albumFragment.javaClass.simpleName)
            .commit()

        bottomNav.setOnNavigationItemSelectedListener {

            when (it.itemId) {
                R.id.search -> {
                    val searchFragment = SearchFragment.newInstance()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, searchFragment!!, searchFragment.javaClass.simpleName)
                        .commit()
                    true
                }
                R.id.top -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, albumFragment!!, albumFragment.javaClass.simpleName)
                        .commit()
                    true
                }
                R.id.main -> {
                    val archiveFragment = ArchiveAlbumFragment.newInstance()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, archiveFragment!!, archiveFragment.javaClass.simpleName)
                        .commit()
                    true
                }

                else -> {
                    false
                }
            }
        }
    }

}
