package com.douglas.android.galleryapp.data.remote.dtos

import com.google.gson.annotations.SerializedName

data class MediaInfoDto(
    @SerializedName("photos")
    var photos: Photos? = null
) {
    val photoIds by lazy { photos?.photo?.let { it.map { photo -> photo.id } } }
}


data class Photo(
    @SerializedName("id")
    var id: String,
    @SerializedName("owner")
    var owner: String,
    @SerializedName("secret")
    var secret: String,
    @SerializedName("server")
    var server: String,
    @SerializedName("farm")
    var farm: Int,
    @SerializedName("title")
    var title: String,
    @SerializedName("ispublic")
    var ispublic: Int,
    @SerializedName("isfriend")
    var isfriend: Int,
    @SerializedName("isfamily")
    var isfamily: Int
)

data class Photos(
    @SerializedName("page")
    var page: Int,
    @SerializedName("pages")
    var pages: Int,
    @SerializedName("perpage")
    var perpage: Int,
    @SerializedName("total")
    var total: String,
    @SerializedName("photo")
    var photo: List<Photo> = listOf()
)