package com.example.samplekmmapp.android.ui

import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.samplekmmapp.android.viewmodel.Result

@BindingAdapter("loadImage")
fun loadNetworkImage(imageView: ImageView, urlsData: Result<List<String>>?) {
    if (urlsData is Result.Success) {
        val uri = urlsData.value[0].toUri().buildUpon().scheme("https").build()
        Glide.with(imageView.context).load(uri).fitCenter().into(imageView)
    } else {
        imageView.setImageResource(0)
    }
}

@BindingAdapter("visibleOrGone")
fun <T> visibleOrGone(view: View, result: Result<T>?) {
    view.visibility = when (result) {
        is Result.Loading -> View.VISIBLE
        else -> View.GONE
    }
}