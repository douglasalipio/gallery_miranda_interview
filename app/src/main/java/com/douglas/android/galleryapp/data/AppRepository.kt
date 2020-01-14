package com.douglas.android.galleryapp.data

import com.douglas.android.galleryapp.data.remote.RemoteDataSource
import com.douglas.android.galleryapp.data.remote.dtos.MediaInfoDto
import com.douglas.android.galleryapp.data.remote.dtos.PhotoDto
import kotlinx.coroutines.Deferred
import javax.inject.Inject

interface AppRepository {

    fun requestMediasInfoAsync(pageNumber: Int): Deferred<List<MediaInfoDto>>

    fun requestPhotosAsync(photoId: Int): Deferred<List<PhotoDto>>

}