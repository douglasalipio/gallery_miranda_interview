package com.douglas.android.galleryapp.features.gallery

import com.douglas.android.galleryapp.data.remote.dtos.PhotoDto
import com.douglas.android.galleryapp.data.remote.dtos.fullImage
import com.douglas.android.galleryapp.data.remote.dtos.largeImage
import com.douglas.android.galleryapp.utils.AppExecutors.Companion.uiContext
import com.douglas.android.galleryapp.utils.launchSilent
import javax.inject.Inject

class GalleryPresenter @Inject constructor(
    private val interactor: GalleryContract.Interactor
) :
    GalleryContract.Presenter {

    private var view: GalleryContract.View? = null


    override fun <T> takeView(view: T) {
        this.view = view as GalleryContract.View
    }

    override fun loadMediaGallery(pageNumber: Int) {
        launchSilent(uiContext) {
            interactor.requestMediaGallery(object : GalleryInteractor.GetMediaCallback {

                override fun onPhotoLoaded(photoDto: PhotoDto) {
                    view?.showPhotos(photoDto.sizes.largeImage(), photoDto.sizes.fullImage())
                }

                override fun onPhotoNotAvailable() {
                    view?.showErrorMessage()
                }
            })
        }
    }

    override fun dropView() {
        view = null
    }

}
