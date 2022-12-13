package com.subeenie.opensource_android.data.remote.response

data class ResponseBoard(
    val message: String,
    val status: Int,
    val success: Boolean,
    val data: posts
) {
    data class posts(
        val id: Int,
        val title: String,
        val content: String
    )
}