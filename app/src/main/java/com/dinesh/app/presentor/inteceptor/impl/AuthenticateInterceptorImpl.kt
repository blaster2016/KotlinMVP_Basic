package com.dinesh.app.presentor.inteceptor.impl

import android.os.Handler
import com.dinesh.app.presentor.inteceptor.AuthenticateInterceptor

/**
 * Created by DineshS on 9/12/2017.
 */
class AuthenticateInterceptorImpl : AuthenticateInterceptor {
    override fun validateUser(userName: String, userPass: String, listner: AuthenticateInterceptor.AuthenticateServiceCompleteListner) {
        Handler().postDelayed({
            if (userName.isEmpty())
                listner.onUserNameFailure()
            else if (userPass.isEmpty())
                listner.onUserPassFailure()
            else
                listner.onSuccess()
        }, 500)
    }
}