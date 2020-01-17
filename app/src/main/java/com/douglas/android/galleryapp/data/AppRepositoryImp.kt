package com.douglas.android.galleryapp.data

import com.douglas.android.galleryapp.data.remote.RemoteDataSource
import javax.inject.Inject

class AppRepositoryImp @Inject constructor(private val remoteDataSource: RemoteDataSource) : AppRepository{

    override fun requestMediaInfo(pageNumber: Int) =remoteDataSource.requestMediasInfoAsync(pageNumber)

    override fun requestPhoto(photoId: Long) = remoteDataSource.requestPhotosAsync(photoId)

}