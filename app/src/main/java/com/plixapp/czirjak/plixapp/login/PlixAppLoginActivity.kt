package com.plixapp.czirjak.plixapp.login

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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        binding.emailSignInButton.setOnClickListener {
            LoginRequest(
                binding.email.text.toString(),
                binding.password.text.toString(),
                Response.Listener { succesResponse ->
                    Toast.makeText(this, "Sikeres belépés.", Toast.LENGTH_LONG).show()
                    startActivity(Intent(this, WildsActivity::class.java))
                },
                Response.ErrorListener { response ->
                    Toast.makeText(this, R.string.error_invalid_password, Toast.LENGTH_LONG).show()
                }).send(this)
        }
    }
}
