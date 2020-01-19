package com.douglas.android.galleryapp.data

import com.douglas.android.galleryapp.data.remote.RemoteDataSource
import javax.inject.Inject

class AppRepositoryImp @Inject constructor(private val remoteDataSource: RemoteDataSource) : AppRepository{

    override suspend fun requestMediaInfoAsync(pageNumber: Int) =remoteDataSource.requestMediasInfoAsync(pageNumber)

    override suspend fun requestPhotoAsync(photoId: Long) = remoteDataSource.requestPhotosAsync(photoId)

}