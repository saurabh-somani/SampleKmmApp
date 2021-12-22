package com.example.samplekmmapp.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MarsProperty(
    val id: String,
    @SerialName("img_src")
    val imgSrcUrl: String,
    val type: String,
    val price: Double) {

    val isRental
        get() = type == "rent"
}