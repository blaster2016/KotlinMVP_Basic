package com.dinesh.app.presentor.presentor

/**
 * Created by DineshS on 9/12/2017.
 */
interface AuthenticatePresentor {
    fun validate(userName: String, userPass: String)
}
