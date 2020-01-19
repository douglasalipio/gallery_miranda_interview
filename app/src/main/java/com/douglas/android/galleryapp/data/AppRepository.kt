package com.douglas.android.galleryapp.data

import com.douglas.android.galleryapp.data.remote.dtos.MediaInfoDto
import com.douglas.android.galleryapp.data.remote.dtos.PhotoDto
import kotlinx.coroutines.Deferred


interface AppRepository {

    suspend fun requestMediaInfoAsync(pageNumber: Int = 1): Deferred<MediaInfoDto>

    suspend fun requestPhotoAsync(photoId: Long): Deferred<PhotoDto>
}