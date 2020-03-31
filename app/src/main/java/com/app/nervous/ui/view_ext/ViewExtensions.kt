package com.app.nervous.ui.view_ext

import android.widget.ImageView
import com.squareup.picasso.Picasso

/**
 * Created by danilorangel on 15/07/18.
 */

fun ImageView.loadImageUrl(url: String?) {
    if (url == null || url.trim().isEmpty()) {
        setImageBitmap(null) //todo set blank image
        return
    }

    Picasso.with(context).load(url).fit().into(this)

}