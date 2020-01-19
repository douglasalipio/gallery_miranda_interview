package com.douglas.android.galleryapp.data.remote

import com.douglas.android.galleryapp.data.remote.dtos.MediaInfoDto
import com.douglas.android.galleryapp.data.remote.dtos.PhotoDto
import kotlinx.coroutines.Deferred

interface RemoteDataSource {

    suspend fun requestMediasInfoAsync(pageNumber: Int): Deferred<MediaInfoDto>

    suspend fun requestPhotosAsync(photoId: Long): Deferred<PhotoDto>
}