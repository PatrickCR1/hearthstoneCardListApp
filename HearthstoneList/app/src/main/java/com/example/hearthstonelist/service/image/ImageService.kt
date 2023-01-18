package com.example.hearthstonelist.service.image

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ImageService private constructor() {

    companion object {

        fun loadImage(context: Context, url: String, view: ImageView, imageWidth: Int,imageHeight: Int) {
            if (url != "") {
                Glide.with(context)
                    .load(url)
                    .apply(RequestOptions.overrideOf(imageWidth,imageHeight))
                    .into(view)
            }
        }
    }
}
