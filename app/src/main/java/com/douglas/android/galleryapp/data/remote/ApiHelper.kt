package com.douglas.android.galleryapp.data.remote

import com.douglas.android.galleryapp.data.remote.dtos.MediaInfoDto
import com.douglas.android.galleryapp.data.remote.dtos.PhotoDto
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

private const val API_KEY = "f9cc014fa76b098f9e82f1c288379ea1"
const val BASE_URL = "https://api.flickr.com"

interface ApiHelper {

    @GET("/services/rest/")
    fun getMediaInfoAsync(
        @Query("method",encoded = true) methodParam: String = "flickr.photos.search",
        @Query("api_key",encoded = true) apiKey: String = API_KEY,
        @Query("tags",encoded = true) tagParam: String = "kitten",
        @Query("format",encoded = true) formatParam: String = "json",
        @Query("nojsoncallback",encoded = true) callbackParam: Int = 1,
        @Query("page",encoded = true) pageParam: Int
    ): Deferred<MediaInfoDto>

    @GET("/services/rest/")
    fun getPhotoAsync(
        @Query("api_key",encoded = true) apiKey: String = API_KEY,
        @Query("format",encoded = true) formatParam: String = "json",
        @Query("nojsoncallback",encoded = true) callbackParam: Int = 1,
        @Query("tags",encoded = true) tagParam: String = "kitten",
        @Query("method",encoded = true) methodParam: String = "flickr.photos.getSizes",
        @Query("photo_id",encoded = true) photoIdParam: Long
    ): Deferred<PhotoDto>
}