package com.example.feedlist.Retrofit

import com.example.feedlist.Model.ResponseModel

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @get:GET("facts.json")
    val dataFromApi: Call<ResponseModel>


}
