package com.douglas.android.galleryapp.features.gallery

import com.babylon.mesquita.interview.foundation.BaseView
import com.douglas.android.galleryapp.foundation.BasePresenter

interface GalleryContract {

	interface View : BaseView<Presenter> {

		fun showPhotos(imageUrl : String)
	}

	interface Presenter : BasePresenter {

		fun loadPhotosGallery(pageNumber: Int = 1)
	}
}
