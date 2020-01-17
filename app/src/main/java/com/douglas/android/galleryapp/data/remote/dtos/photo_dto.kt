package com.douglas.android.galleryapp.data.remote.dtos

import com.google.gson.annotations.SerializedName


data class PhotoDto(
    @SerializedName("sizes")
    var sizes: Sizes
) {
    companion object {
        const val LARGE_IMAGE = "Large Square"
    }
}

data class Size(
    @SerializedName("label")
    var label: String,
    @SerializedName("width")
    var width: Int,
    @SerializedName("height")
    var height: Int,
    @SerializedName("source")
    var source: String,
    @SerializedName("url")
    var url: String,
    @SerializedName("media")
    var media: String
)

data class Sizes(
    @SerializedName("canblog")
    var canblog: Int,
    @SerializedName("canprint")
    var canprint: Int,
    @SerializedName("candownload")
    var candownload: Int,
    @SerializedName("size")
    var size: List<Size>
)

fun Sizes.largeImage() = size.find { it.label == PhotoDto.LARGE_IMAGE }?.source.orEmpty()