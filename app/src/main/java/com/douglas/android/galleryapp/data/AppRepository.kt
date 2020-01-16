package com.douglas.android.galleryapp.data

import com.douglas.android.galleryapp.data.remote.dtos.MediaInfoDto
import com.douglas.android.galleryapp.data.remote.dtos.PhotoDto
import io.reactivex.Observable


interface AppRepository {

    fun requestMediasInfoAsync(pageNumber: Int): Observable<MediaInfoDto>

    fun requestPhotosAsync(photoId: Long): Observable<PhotoDto>
}