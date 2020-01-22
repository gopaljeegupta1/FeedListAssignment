package com.example.feedlist.viewmodel


import android.widget.ImageView

import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.feedlist.Model.ResponseModel
import com.example.feedlist.R
import com.example.feedlist.Retrofit.ApiClient
import com.example.feedlist.utils.NetworkConnectionInterceptor

import java.util.ArrayList

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyListViewModel : ViewModel {

    var id = ""
    var rowTitle: String? = ""
    var rowContent: String? = ""
    var rowImage: String? = ""
    var title: String? = ""

    var mutableLiveData = MutableLiveData<List<MyListViewModel>>()
    private val arrayList = ArrayList<MyListViewModel>()
    private var myList: ResponseModel? = null


    constructor() {

    }

    constructor(myList: ResponseModel.Row) {
        //        this.id = myList.id;
        if (null != myList.title) {
            this.rowTitle = myList.title
        }
        if (null != myList.description) {

            this.rowContent = myList.description
        }
        if (null != myList.imageHref) {
            this.rowImage = myList.imageHref
        }
    }

    fun getMutableLiveData1(): MutableLiveData<List<MyListViewModel>> {

        //        arrayList = new ArrayList<>();

        val api = ApiClient.instance.apiClient
        val call = api.dataFromApi
        call.enqueue(object : Callback<ResponseModel> {
            override fun onResponse(call: Call<ResponseModel>, response: Response<ResponseModel>) {

                if (response.isSuccessful) {
                    myList = response.body()
                    title = myList!!.title
                    for (element in myList!!.rows!!) {

                        val myListViewModel = MyListViewModel(element)
                        arrayList.add(myListViewModel)

                        mutableLiveData.value = arrayList
                    }
                }

            }

            override fun onFailure(call: Call<ResponseModel>, t: Throwable) {

            }
        })

        return mutableLiveData
    }

    companion object {
        @JvmStatic // add this line !!
        @BindingAdapter("imageUrl")
        fun loadimage(imageView: ImageView, imageUrl: String) {

            val options = RequestOptions()
                    .placeholder(R.mipmap.ic_launcher)
                    .error(R.mipmap.ic_launcher)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .priority(Priority.HIGH)
                    .dontAnimate()
                    .dontTransform()

            Glide.with(imageView.context).load(imageUrl).apply(options).into(imageView)

        }
    }


}