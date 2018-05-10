package com.dinesh.app.ui.activity

import android.content.Intent
import android.os.Handler

class LauncherActivity : android.support.v7.app.AppCompatActivity() {

    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.dinesh.app.R.layout.activity_launcher)

        Handler().postDelayed({
            var intent = Intent(this, AuthenticateActivity::class.java)
            startActivity(intent)
            finish()
        }, 2500)
    }
}
