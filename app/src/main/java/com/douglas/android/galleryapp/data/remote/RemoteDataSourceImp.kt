package com.douglas.android.galleryapp.data.remote

import javax.inject.Inject

class RemoteDataSourceImp @Inject constructor(private val apiHelper: ApiHelper) : RemoteDataSource {

    override fun requestMediasInfoAsync(pageNumber: Int) = apiHelper.getMediaInfoAsync(pageParam = pageNumber)

    override fun requestPhotosAsync(photoId: Long) = apiHelper.getPhotoAsync(photoIdParam = photoId)

}