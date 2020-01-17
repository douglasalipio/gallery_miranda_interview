package com.douglas.android.galleryapp.features

import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.douglas.android.galleryapp.R
import com.douglas.android.galleryapp.features.gallery.GalleryCardItem
import com.douglas.android.galleryapp.features.gallery.GalleryContract
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Section


import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity(), GalleryContract.View {

    @Inject
    lateinit var presenter: GalleryContract.Presenter
    private val groupAdapter = GroupAdapter<GroupieViewHolder>()
    private val section = Section()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.takeView(this)
        presenter.loadPhotosGallery(1)
        val layoutManager = GridLayoutManager(this, 2)
        layoutManager.spanSizeLookup = groupAdapter.spanSizeLookup
        galleryList?.let {
            it.layoutManager = layoutManager
            it.adapter = groupAdapter
        }
    }

    override fun showPhotos(imageUrl: String) {
        groupAdapter.add(GalleryCardItem(imageUrl))
    }
}
