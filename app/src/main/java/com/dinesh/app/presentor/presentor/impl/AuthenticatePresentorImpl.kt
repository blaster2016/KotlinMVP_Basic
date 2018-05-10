package com.dinesh.app.presentor.presentor.impl

import com.dinesh.app.presentor.inteceptor.AuthenticateInterceptor
import com.dinesh.app.presentor.inteceptor.impl.AuthenticateInterceptorImpl
import com.dinesh.app.presentor.presentor.AuthenticatePresentor
import com.dinesh.app.view.AuthenticateView

/**
 * Created by DineshS on 9/12/2017.
 */
class AuthenticatePresentorImpl : AuthenticatePresentor, AuthenticateInterceptor.AuthenticateServiceCompleteListner {

    var authInterceptor: AuthenticateInterceptorImpl? = null
    var authView: AuthenticateView? = null

    constructor(authView: AuthenticateView) {
        this.authView = authView
        authInterceptor = AuthenticateInterceptorImpl()
    }

    override fun validate(userName: String, userPass: String) {
        authView?.showProgress()
        authInterceptor?.validateUser(userName, userPass, this)
    }

    override fun onFailure() {
        authView?.hideProgress()
    }

    override fun onSuccess() {
        authView?.hideProgress()
        authView?.navigate()
    }

    override fun onUserNameFailure() {
        authView?.hideProgress()
        authView?.onUserNameError()
    }

    override fun onUserPassFailure() {
        authView?.hideProgress()
        authView?.onUserPassError()
    }
}