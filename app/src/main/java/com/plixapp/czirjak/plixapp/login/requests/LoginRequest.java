package com.plixapp.czirjak.plixapp.login.requests;

import com.android.volley.Response;
import com.plixapp.czirjak.plixapp.common.Constants;
import com.rainy.networkhelper.annotation.*;
import com.rainy.networkhelper.request.ParserRequest;
import com.rainy.networkhelper.response.ParsedResponse;

import kotlin.io.ConstantsKt;

import static com.plixapp.czirjak.plixapp.common.Constants.ACCEPT;
import static com.plixapp.czirjak.plixapp.common.Constants.ACCEPT_LANGUAGE;
import static com.plixapp.czirjak.plixapp.common.Constants.BASE_HOST;
import static com.plixapp.czirjak.plixapp.common.Constants.CACHECONTROL;
import static com.plixapp.czirjak.plixapp.common.Constants.DEVICEID;
import static com.plixapp.czirjak.plixapp.common.Constants.TOKEN;

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


    public LoginRequest(String email, String password, Response.Listener<ParsedResponse<LoginResponse>> listener, Response.ErrorListener errorListener) {
        super(listener, errorListener);
        this.email = email;
        this.password = password;
    }

}