package com.plixapp.czirjak.plixapp.login

import android.app.ActivityOptions
import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.Response

import com.plixapp.czirjak.plixapp.R
import com.plixapp.czirjak.plixapp.databinding.ActivityLoginBinding
import com.plixapp.czirjak.plixapp.login.requests.LoginRequest
import com.plixapp.czirjak.plixapp.wilds.WildsActivity

/**
 * A login screen that offers login via email/password.
 */
class PlixAppLoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private var loginRequest: LoginRequest? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        binding.emailSignInButton.setOnClickListener {
           loginRequest = LoginRequest(
                binding.email.text.toString(),
                binding.password.text.toString(),
                Response.Listener { succesResponse ->
                    Toast.makeText(this, "Sikeres belépés.", Toast.LENGTH_LONG).show()
                    startActivity(Intent(this, WildsActivity::class.java), ActivityOptions.makeCustomAnimation(this, R.anim.abc_slide_in_bottom, R.anim.abc_slide_out_top).toBundle())
                },
                Response.ErrorListener { response ->
                    Toast.makeText(this, R.string.error_invalid_credentials, Toast.LENGTH_LONG).show()
                })

            loginRequest?.send(this)
        }
    }

    override fun onStop() {
        super.onStop()
        loginRequest?.cancel()
    }
}
