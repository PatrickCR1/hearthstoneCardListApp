package com.example.hearthstonelist.service.image

import android.content.Context
import android.widget.ImageView
import com.squareup.picasso.Picasso

class ImageService private constructor() {

    companion object {

        fun loadImage(context: Context, url: String, view: ImageView) {
            if (url != "") {
                Picasso.with(context)
                    .load(url)
                    .into(view)
            }
        }
    }
}
