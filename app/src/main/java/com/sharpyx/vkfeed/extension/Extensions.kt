package com.sharpyx.vkfeed.extension

import android.content.Context
import android.widget.ImageView
import android.widget.Toast
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

fun Context.toast(msg: String, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, msg, length).show()
}

fun Context.toast(msgResource: Int, length: Int = Toast.LENGTH_SHORT) {
    this.toast(getString(msgResource), length)
}