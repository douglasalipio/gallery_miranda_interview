package com.douglas.android.galleryapp.features.gallery

import com.bumptech.glide.Glide
import com.douglas.android.galleryapp.R
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.photo_item.view.*


class GalleryCardItem(
    private val largeImgUrl: String,
    private val fullImgUrl: String,
    private val clickListener: (String) -> Unit
) : Item() {

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        with(viewHolder.itemView) {
            Glide.with(context).load(largeImgUrl).into(photoImg)
            setOnClickListener { clickListener(fullImgUrl) }
        }
    }

    override fun getLayout() = R.layout.photo_item

}