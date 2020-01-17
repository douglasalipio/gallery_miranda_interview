package com.douglas.android.galleryapp.features.gallery

import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.douglas.android.galleryapp.R
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.photo_item.view.*


class GalleryCardItem(private val url: String) : Item() {

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        val context = viewHolder.itemView.context
        Glide.with(context)
            .load(url)
            .into(viewHolder.itemView.photo)
    }

    override fun getLayout() = R.layout.photo_item

}