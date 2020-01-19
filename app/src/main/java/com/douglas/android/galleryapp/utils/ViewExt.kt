package com.douglas.android.galleryapp.utils

import android.content.Context
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.customview.customView
import com.bumptech.glide.Glide
import com.douglas.android.galleryapp.R
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import kotlinx.android.synthetic.main.full_photo_view.view.*


fun RecyclerView.initGridLayout(
    context: Context,
    groupAdapter: GroupAdapter<GroupieViewHolder>,
    numberColumn: Int
) {
    val gridLayoutManager = GridLayoutManager(context, numberColumn)
    gridLayoutManager.spanSizeLookup = groupAdapter.spanSizeLookup
    this.adapter = groupAdapter
    this.layoutManager = gridLayoutManager
}

fun Context.showFullPhotoDialog(url: String) {
    val dialog = MaterialDialog(this)
    dialog.window?.attributes?.windowAnimations = R.style.DialogAnimation
    dialog.show {
        customView(R.layout.full_photo_view)
        Glide.with(context).load(url).into(view.fullImage)
        cornerRadius(16f)
        title(text = context.getString(R.string.image_dialog_title))
        positiveButton { this.dismiss() }
    }
}