package com.douglas.android.galleryapp.data.remote

import com.douglas.android.galleryapp.data.remote.dtos.MediaInfoDto
import com.douglas.android.galleryapp.data.remote.dtos.PhotoDto
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

private const val API_KEY = "f9cc014fa76b098f9e82f1c288379ea1"
const val BASE_URL = "https://api.flickr.com/services/rest/"

interface ApiHelper {

    @GET
    fun getMediaInfoAsync(
        @Query("method") methodParam: String = "flickr.photos.search",
        @Query("api_key") apiKey: String = API_KEY,
        @Query("tags") tagParam: String = "kitten",
        @Query("format") formatParam: String = "json",
        @Query("nojsoncallback") callbackParam: Int = 1,
        @Query("page") pageParam: Int
    ): Deferred<List<MediaInfoDto>>

    @GET
    fun getPhotoAsync(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("format") formatParam: String = "json",
        @Query("nojsoncallback") callbackParam: Int = 1,
        @Query("tags") tagParam: String = "kitten",
        @Query("method") methodParam: String = "flickr.photos.search",
        @Query("photo_id") photoIdParam: Int
    ): Deferred<List<PhotoDto>>
}