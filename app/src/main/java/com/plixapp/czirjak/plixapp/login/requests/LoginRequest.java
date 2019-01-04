package com.plixapp.czirjak.plixapp.login.requests;

import com.android.volley.Response;
import com.rainy.networkhelper.annotation.HeaderParam;
import com.rainy.networkhelper.annotation.RequestMethod;
import com.rainy.networkhelper.request.ParserRequest;
import com.rainy.networkhelper.response.ParsedResponse;

import static com.plixapp.czirjak.plixapp.common.Constants.*;

@RequestMethod(url = BASE_HOST +"/api/v1/login")
public class LoginRequest extends ParserRequest<LoginResponse> {

    @HeaderParam(name = "Authorization")
    private String auth = TOKEN;

    @HeaderParam(name = "deviceid")
    private String deviceid = DEVICEID;

    @HeaderParam(name = "Accept")
    private String accept = ACCEPT;

    @HeaderParam(name = "Cache-Control")
    private String cacheControl = CACHECONTROL;

    @HeaderParam(name = "Accept-Language")
    private String acceptlanguage = ACCEPT_LANGUAGE;

    @HeaderParam(name = "email")
    private String email;

    @HeaderParam(name = "password")
    private String password;


    public LoginRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

}