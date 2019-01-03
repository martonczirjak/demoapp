package com.plixapp.czirjak.plixapp.login

import android.database.DatabaseUtils
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import com.plixapp.czirjak.plixapp.R
import com.plixapp.czirjak.plixapp.databinding.ActivityLoginBinding

/**
 * A login screen that offers login via email/password.
 */
class PlixAppLoginActivity : AppCompatActivity() {

    private lateinit var binding : ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_login)


    }
}
