package com.subeenie.opensource_android

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

object ServiceCreator {

    private val client by lazy {
        OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            ).build()
    }
    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("http://opensource.sample.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }
    inline fun <reified T> create(): T = retrofit.create<T>(T::class.java)
    val boardService: BoardService = retrofit.create(BoardService::class.java)
}
