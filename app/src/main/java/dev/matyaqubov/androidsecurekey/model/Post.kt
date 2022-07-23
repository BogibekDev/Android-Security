package dev.matyaqubov.androidsecurekey.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Post(
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("userId")
    val userId: Int = 0,
    @SerializedName("title")
    var title: String? = null,
    @SerializedName("body")
    var body: String? = null,
) : Serializable
