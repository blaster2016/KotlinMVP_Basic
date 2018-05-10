package com.dinesh.app.util

import android.content.Context
import android.net.ConnectivityManager

/**
 * Created by DineshS on 9/11/2017.
 */
class NetworkUtils {
    companion object {
        fun isNetworkConnected(context: Context?): Boolean {
            val connectivityManager = context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val networkInfo = connectivityManager.activeNetworkInfo
            return networkInfo != null && networkInfo.isConnected
        }
    }
}