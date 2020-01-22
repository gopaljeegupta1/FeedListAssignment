package com.example.feedlist.Retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient


class ApiClient private constructor() {
    private val retrofit: Retrofit
//    private val interceptor: NetworkConnectionInterceptor? = null
    val apiClient: ApiInterface
        get() = retrofit.create(ApiInterface::class.java)

    init {

//        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
//                .client(client)
                .build()
    }


    companion object {
        private val BASE_URL = "https://dl.dropboxusercontent.com/s/2iodh4vg0eortkl/"
        private var myClient: ApiClient? = null

        val instance: ApiClient
            @Synchronized get() {
                if (myClient == null) {
                    myClient = ApiClient()
                }
                return myClient as ApiClient
            }
    }


}
