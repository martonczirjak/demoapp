package com.plixapp.czirjak.plixapp.login

import android.app.ActivityOptions
import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

import com.plixapp.czirjak.plixapp.R
import com.plixapp.czirjak.plixapp.databinding.ActivityLoginBinding
import com.plixapp.czirjak.plixapp.login.requests.LoginResponse
import com.plixapp.czirjak.plixapp.login.requests.LoginRequest
import com.plixapp.czirjak.plixapp.webservice.LoginService
import com.plixapp.czirjak.plixapp.wilds.WildsActivity
import com.rainy.networkhelper.future.ExecutionFuture

/**
 * A login screen that offers login via email/password.
 */
class PlixAppLoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private var loginRequest: ExecutionFuture<LoginResponse>? = null
    // private var loginRequest: LoginRequest? = null
    private var loginRequest2: LoginRequest? = null
    private val loginService = LoginService()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        binding.emailSignInButton.setOnClickListener {
            binding.loginProgress.visibility = View.VISIBLE
            binding.emailSignInButton.isEnabled = false
            loginRequest = loginService.login(binding.email.text.toString(), binding.password.text.toString(), this)
            loginRequest?.enqueue(
                {
                    binding.loginProgress.visibility = View.GONE
                    binding.emailSignInButton.isEnabled = true
                    startActivity(Intent(this, WildsActivity::class.java),ActivityOptions.makeCustomAnimation(this,R.anim.abc_slide_in_bottom,R.anim.abc_slide_out_top).toBundle())
                },
                {
                    binding.loginProgress.visibility = View.GONE
                    binding.emailSignInButton.isEnabled = true
                    Toast.makeText(this, R.string.error_invalid_credentials, Toast.LENGTH_LONG).show()
                })
        }
    }

    override fun onStop() {
        super.onStop()
        loginRequest?.cancel(true)
    }
}
