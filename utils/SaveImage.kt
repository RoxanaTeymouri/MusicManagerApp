package ir.android.musicmanager.utils

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.os.Environment
import com.squareup.picasso.Picasso
import com.squareup.picasso.Target
import java.io.File
import java.io.FileOutputStream

object SaveImage {

    fun getTarget(mbid: String): Target {
        return object : Target {

            override fun onBitmapLoaded(bitmap: Bitmap, from: Picasso.LoadedFrom) {

                Thread(Runnable {
                    val file =
                        File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).absolutePath + "/" + mbid + ".jpg")
                    try {
                        file.createNewFile()
                        val ostream = FileOutputStream(file)
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 75, ostream)
                        ostream.close()
                    } catch (e: Exception) {

                        e.printStackTrace()
                    }
                }).start()
            }

            override fun onBitmapFailed(errorDrawable: Drawable) {}
            override fun onPrepareLoad(placeHolderDrawable: Drawable?) {
                if (placeHolderDrawable != null) {
                }
            }
        }
    }

}
