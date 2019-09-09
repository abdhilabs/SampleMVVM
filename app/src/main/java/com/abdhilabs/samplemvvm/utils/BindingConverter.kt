package com.abdhilabs.samplemvvm.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.abdhilabs.samplemvvm.R
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.request.RequestOptions

/**
 * untuk menampilkan gambar secara data binding
 */

class BindingConverter {

    companion object {

        @JvmStatic
        @BindingAdapter("loadImage")
        fun loadImage(imageView: ImageView, url: String) {
            Glide.with(imageView.context)
                .load("https://image.tmdb.org/t/p/w500$url")
                .apply(
                    RequestOptions()
                        .placeholder(R.drawable.ic_launcher_background)
                        .error(R.drawable.ic_launcher_background)
                        .format(DecodeFormat.PREFER_ARGB_8888)
                )
                .into(imageView)
        }
    }
}