package com.douglas.android.galleryapp.features.gallery

import com.douglas.android.galleryapp.data.AppRepository
import javax.inject.Inject

class GalleryPresenter @Inject constructor(private val repository: AppRepository) :
	GalleryContract.Presenter {

	private var view: GalleryContract.View? = null

	override fun <T> takeView(view: T) {
		this.view = view as GalleryContract.View
	}



	override fun dropView() {
		view = null
	}

}
