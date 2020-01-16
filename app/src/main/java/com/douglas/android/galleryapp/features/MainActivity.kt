package com.douglas.android.galleryapp.features

import android.os.Bundle
import com.douglas.android.galleryapp.R
import com.douglas.android.galleryapp.features.gallery.GalleryContract
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity(), GalleryContract.View {

    @Inject
    lateinit var presenter: GalleryContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.takeView(this)
        presenter.loadPhotosGallery(1)
    }

    override fun showPhotos(imageUrl: String) {

    }
}
