package com.dinesh.app.view

/**
 * Created by DineshS on 9/12/2017.
 */
interface AuthenticateView {
    fun onUserNameError()
    fun onUserPassError()
    fun showProgress()
    fun hideProgress()
    fun navigate()
}