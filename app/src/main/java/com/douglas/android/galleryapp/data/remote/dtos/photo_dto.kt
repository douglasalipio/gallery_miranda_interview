package com.douglas.android.galleryapp.data.remote.dtos

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


data class PhotoDto(
    @SerializedName("sizes")
    @Expose
    var sizes: Sizes
)

data class Size(
    @SerializedName("label")
    @Expose
    var label: String,
    @SerializedName("width")
    @Expose
    var width: Int,
    @SerializedName("height")
    @Expose
    var height: Int,
    @SerializedName("source")
    @Expose
    var source: String,
    @SerializedName("url")
    @Expose
    var url: String,
    @SerializedName("media")
    @Expose
    var media: String
)

data class Sizes(
    @SerializedName("canblog")
    @Expose
    var canblog: Int,
    @SerializedName("canprint")
    @Expose
    var canprint: Int,
    @SerializedName("candownload")
    @Expose
    var candownload: Int,
    @SerializedName("size")
    @Expose
    var size: List<Size>
)