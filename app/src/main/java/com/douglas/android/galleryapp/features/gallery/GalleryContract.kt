package com.douglas.android.galleryapp.features.gallery

import com.douglas.android.galleryapp.features.foundation.BaseInteractor
import com.douglas.android.galleryapp.features.foundation.BaseView
import com.douglas.android.galleryapp.features.foundation.BasePresenter

interface GalleryContract {

    interface View : BaseView<Presenter> {

        fun showPhotos(largeImgUrl: String, fullImgUrl: String)
        fun showErrorMessage()
    }

    interface Presenter : BasePresenter {

        fun loadMediaGallery(pageNumber: Int = 1)

    }

    interface Interactor : BaseInteractor {

        suspend fun requestMediaGallery(getMediaCallback: GalleryInteractor.GetMediaCallback)
    }
}
