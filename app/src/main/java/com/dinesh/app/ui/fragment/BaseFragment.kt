package com.dinesh.app.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dinesh.app.util.callback.NetworkCallback

/**
 * Created by DineshS on 9/12/2017.
 */
abstract class BaseFragment : Fragment(), NetworkCallback {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(setLayout(), container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        layoutAdded(view, savedInstanceState)
    }

    abstract fun layoutAdded(savedInstanceState: View?, savedInstanceState1: Bundle?)

    abstract fun setLayout(): Int

    abstract fun onNetworkChange(isConnected: Boolean): Boolean

    override fun networkChange(isConnected: Boolean) {
        onNetworkChange(isConnected)
    }
}