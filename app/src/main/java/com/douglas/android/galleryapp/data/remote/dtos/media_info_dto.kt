package com.douglas.android.galleryapp.data.remote.dtos

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MediaInfoDto(
    @SerializedName("photos")
    @Expose
    var photos: Photos? = null
)

data class Photo(
    @SerializedName("id")
    @Expose
    var id: String,
    @SerializedName("owner")
    @Expose
    var owner: String,
    @SerializedName("secret")
    @Expose
    var secret: String,
    @SerializedName("server")
    @Expose
    var server: String,
    @SerializedName("farm")
    @Expose
    var farm: Int,
    @SerializedName("title")
    @Expose
    var title: String,
    @SerializedName("ispublic")
    @Expose
    var ispublic: Int,
    @SerializedName("isfriend")
    @Expose
    var isfriend: Int,
    @SerializedName("isfamily")
    @Expose
    var isfamily: Int
)

data class Photos(
    @SerializedName("page")
    @Expose
    var page: Int,
    @SerializedName("pages")
    @Expose
    var pages: Int,
    @SerializedName("perpage")
    @Expose
    var perpage: Int,
    @SerializedName("total")
    @Expose
    var total: String,
    @SerializedName("photo")
    @Expose
    var photo: List<Photo> = listOf()
)