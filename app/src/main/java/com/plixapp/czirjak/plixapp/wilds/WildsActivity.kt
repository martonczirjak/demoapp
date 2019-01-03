package com.plixapp.czirjak.plixapp.wilds

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.Response

import com.plixapp.czirjak.plixapp.R
import com.plixapp.czirjak.plixapp.databinding.ActivityLoginBinding
import com.plixapp.czirjak.plixapp.databinding.ActivityWildsBinding
import com.plixapp.czirjak.plixapp.login.requests.LoginRequest
import com.plixapp.czirjak.plixapp.wilds.requests.GetWildsRequest

/**
 * A login screen that offers login via email/password.
 */
class WildsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWildsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_wilds)

        GetWildsRequest(
            "-",
            "--",
            Response.Listener { succesResponse ->
                Toast.makeText(this, "LETÖLTVE.", Toast.LENGTH_LONG).show()
            },
            Response.ErrorListener { response ->
                Toast.makeText(this, R.string.download_error, Toast.LENGTH_LONG).show()
            }).send(this)


    }
}
