package ir.android.musicmanager.pojos.search

/**
 * Created by  Roxa on 5/15/2019.
 */

import ir.android.musicmanager.pojos.ImageItem

data class Artist(var name: String, var listeners: String, var mbid: String, var url: String,
                  var streamable: String, var image: kotlin.collections.List<ImageItem>)




