package com.example.samplekmmapp.android.ui

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("loadImage")
fun loadImage(imageView: ImageView, urls: List<String>?) {
    urls?.let {
        val uri = it[0].toUri().buildUpon().scheme("https").build()
        Glide.with(imageView.context).load(uri).fitCenter().into(imageView)
    }
}