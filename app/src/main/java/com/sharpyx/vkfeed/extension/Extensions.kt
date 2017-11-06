package com.sharpyx.vkfeed.extension

import android.widget.ImageView
import com.bumptech.glide.Glide

/**
 * @author Artem Sckopincev (aka sharpyx)
 */

/**
 * Loading image by url into ImageView
 */
fun ImageView.loadImage(url: String) {
    Glide.with(context).load(url).into(this)
}