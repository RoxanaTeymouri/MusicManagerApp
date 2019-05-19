package ir.android.musicmanager.topalbum

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import ir.android.musicmanager.pojos.topAlbum.AlbumDetailDataBase
import ir.android.musicmanager.pojos.topAlbum.IMDB
import java.sql.SQLException

class DataBaseHelper(

    context: Context?,
    factory: SQLiteDatabase.CursorFactory?
) :
    SQLiteOpenHelper(
        context, DATABASE_NAME,
        factory, DATABASE_VERSION
    ) {
    override fun onCreate(db: SQLiteDatabase) {
        val CREATE_TABLE_ALBUM = ("CREATE TABLE " +
                TABLE_NAME + "("
                + COLUMN_ID + "INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_ARTIST_NAME + " TEXT,"
                + COLUMN_ALBUM_NAME + " TEXT,"
                + COLUMN_IMAGE_ALBUM + " TEXT)")
        db.execSQL(CREATE_TABLE_ALBUM)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
        onCreate(db)
    }

    fun drop(context: Context) {
        val db = this.writableDatabase
        val CREATE_TABLE_ALBUM = ("CREATE TABLE " +
                TABLE_NAME + "("
                + COLUMN_ID + "INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_ARTIST_NAME + " TEXT,"
                + COLUMN_ALBUM_NAME + " TEXT,"
                + COLUMN_IMAGE_ALBUM + " TEXT)")
        db.execSQL(CREATE_TABLE_ALBUM)
        // db.execSQL("DROP TABLE IF EXISTS " + DataBaseHelper.TABLE_NAME)
    }

    fun addAlbum(albumDetails: AlbumDetailDataBase) {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(COLUMN_ARTIST_NAME, albumDetails.artistName)
        values.put(COLUMN_ALBUM_NAME, albumDetails.albumName)
        values.put(COLUMN_IMAGE_ALBUM, albumDetails.mbid)

        db.insert(TABLE_NAME, null, values)
        db.close()
    }

    fun getAllAlbums(): List<AlbumDetailDataBase> {
        val list = ArrayList<AlbumDetailDataBase>()

        var db = this.readableDatabase
        var cursor = db.rawQuery("SELECT * FROM albumTable ", null)

        while (cursor.moveToNext()) {
            val albumDetails = AlbumDetailDataBase()
          //  albumDetails.id = cursor.getInt(0)
            albumDetails.artistName = cursor.getString(0)
            albumDetails.albumName = cursor.getString(1)
            albumDetails.mbid = cursor.getString(2)

            list.add(albumDetails)
        }
        db.close()
        return list
    }


    fun deleteAlbums(): Boolean {
        try {

            var deleteQuery = "DELETE FROM " + TABLE_NAME
            var db = this.writableDatabase

            db.execSQL(deleteQuery)
            db.close()
            return true
        } catch (e: SQLException) {
            return false
        }
    }

    companion object {
        private val DATABASE_VERSION = 1
        val TABLE_NAME = "albumTable"
        val COLUMN_ID = "_id "
        val COLUMN_ARTIST_NAME = "artistName"
        val COLUMN_ALBUM_NAME = "albumName"
        val COLUMN_IMAGE_ALBUM = "imageAlbum"
        private val DATABASE_NAME = "albumsDetails.db"

    }
}