package com.example.feedlist.utils

import android.content.Context
import android.net.ConnectivityManager
import okhttp3.Interceptor
import okhttp3.Response


class NetworkConnectionInterceptor(context: Context) : Interceptor {

    private val appContext = context

    public fun isInternetConnected(): Boolean {

        val connectivityManager = appContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = connectivityManager.activeNetworkInfo.also {
            return it != null && it.isConnected
        }


    }


    override fun intercept(chain: Interceptor.Chain): Response {
        if (!isInternetConnected()) {
            throw NoConnectivityException()
            // Throwing our custom exception 'NoConnectivityException'
        }

        return chain.proceed(chain.request())
    }

}