package com.douglas.android.galleryapp.data.remote

import com.douglas.android.galleryapp.data.remote.dtos.MediaInfoDto
import com.douglas.android.galleryapp.data.remote.dtos.PhotoDto
import kotlinx.coroutines.Deferred

interface RemoteDataSource {

    fun requestMediasInfoAsync(pageNumber : Int): Deferred<List<MediaInfoDto>>

    fun requestPhotosAsync(photoId: Int): Deferred<List<PhotoDto>>
}