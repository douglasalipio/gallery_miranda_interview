package com.douglas.android.galleryapp.features.gallery

import com.douglas.android.galleryapp.data.AppRepository
import com.douglas.android.galleryapp.data.remote.dtos.PhotoDto
import javax.inject.Inject

class GalleryInteractor @Inject constructor(private val appRepository: AppRepository) :
    GalleryContract.Interactor {

    interface GetMediaCallback {
        fun onPhotoLoaded(photoDto: PhotoDto)
        fun onPhotoNotAvailable()
    }

    override suspend fun requestMediaGallery(getMediaCallback: GetMediaCallback) {

        val mediaInfoDto = appRepository.requestMediaInfoAsync(1).await()
        mediaInfoDto.photoIds?.map {
            val photoDto = appRepository.requestPhotoAsync(it.toLong()).await()
            getMediaCallback.onPhotoLoaded(photoDto)
        }
    }
}