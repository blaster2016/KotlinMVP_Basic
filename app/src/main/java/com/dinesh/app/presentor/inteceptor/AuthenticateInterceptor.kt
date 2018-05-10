package com.dinesh.app.presentor.inteceptor

/**
 * Created by DineshS on 9/12/2017.
 */

interface AuthenticateInterceptor {

    interface AuthenticateServiceCompleteListner {
        fun onSuccess()
        fun onFailure()
        fun onUserNameFailure()
        fun onUserPassFailure()
    }

    fun validateUser(userName: String, userPass: String, listner: AuthenticateServiceCompleteListner)
}
