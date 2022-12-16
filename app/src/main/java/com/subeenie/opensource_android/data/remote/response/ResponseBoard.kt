package com.subeenie.opensource_android.data.remote.response

data class ResponseBoard(
    val message: String,
    val status: Int,
    val data: Data
) {
    data class Data(
        val posts: List<Posts>
    ) {
        data class Posts(
            val id: Int,
            val title: String,
            val content: String
        )

    }

}