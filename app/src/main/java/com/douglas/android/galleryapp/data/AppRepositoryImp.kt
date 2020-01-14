package com.douglas.android.galleryapp.data

import com.douglas.android.galleryapp.data.remote.RemoteDataSource
import javax.inject.Inject

class AppRepositoryImp @Inject constructor(private val remoteDataSource: RemoteDataSource) : AppRepository{

    override fun requestMediasInfoAsync(pageNumber: Int) =remoteDataSource.requestMediasInfoAsync(pageNumber)

    override fun requestPhotosAsync(photoId: Int) = remoteDataSource.requestPhotosAsync(photoId)

}