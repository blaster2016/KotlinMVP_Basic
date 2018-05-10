package com.dinesh.app.ui.activity

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.support.v4.content.LocalBroadcastManager
import android.support.v7.app.AppCompatActivity
import android.widget.EditText
import android.widget.TextView
import com.dinesh.app.util.Consts
import com.dinesh.app.util.NetworkUtils
import com.dinesh.app.util.callback.NetworkCallback

/**
 * Created by DineshS on 9/11/2017.
 */

abstract class BaseActivity : AppCompatActivity(), NetworkCallback {
    var networkBroadcast: BroadcastReceiver? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(setLayout())
        layoutAdded(savedInstanceState)

    }

    abstract fun layoutAdded(savedInstanceState: Bundle?)


    abstract fun setLayout(): Int

    abstract fun onNetworkChange(isConnected: Boolean)

    override fun networkChange(isConnected: Boolean) {
        onNetworkChange(isConnected)
    }

    override fun onStart() {
        super.onStart()
        registerNetworkBroadcast()
    }

    fun registerNetworkBroadcast() {
        networkBroadcast = object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                networkChange(NetworkUtils.isNetworkConnected(context))
            }
        }
        try {
            LocalBroadcastManager.getInstance(this).registerReceiver(networkBroadcast, IntentFilter(Consts.NETWORK_BR))
        } catch (exception: Exception) {
            exception.printStackTrace()
        }
    }

    fun getText(editText: EditText?): String {
        return editText?.text.toString().trim()
    }

    fun getText(textView: TextView?): String {
        return textView?.text.toString().trim()
    }

}
