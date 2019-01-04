package com.plixapp.czirjak.plixapp.webservice

import android.content.Context
import com.plixapp.czirjak.plixapp.login.requests.LoginRequest
import com.plixapp.czirjak.plixapp.login.requests.LoginResponse
import com.rainy.networkhelper.future.ExecutionFuture

class LoginService {
    fun login(email: String, password: String, context: Context): ExecutionFuture<LoginResponse> {
        return LoginRequest(email, password).getParsedFuture(context)
    }
}
