package com.plixapp.czirjak.plixapp.wilds.requests

import com.android.volley.Response
import com.plixapp.czirjak.plixapp.common.Constants
import com.plixapp.czirjak.plixapp.login.requests.LoginResponse
import com.rainy.networkhelper.annotation.HeaderParam
import com.rainy.networkhelper.annotation.RequestMethod
import com.rainy.networkhelper.request.ParserRequest
import com.rainy.networkhelper.response.ParsedResponse

import com.plixapp.czirjak.plixapp.common.Constants.BASE_HOST
import com.plixapp.czirjak.plixapp.common.Constants.TOKEN
import com.plixapp.czirjak.plixapp.common.Constants.DEVICEID
import com.plixapp.czirjak.plixapp.common.Constants.ACCEPT
import com.plixapp.czirjak.plixapp.common.Constants.CACHECONTROL
import com.plixapp.czirjak.plixapp.common.Constants.ACCEPT_LANGUAGE

@RequestMethod(url = Constants.BASE_HOST + "api/v1/master/wilds")
class GetWildsRequest : ParserRequest<WildResponse> {

    @HeaderParam(name = "Authorization")
    private val auth = TOKEN

    @HeaderParam(name = "deviceid")
    private val deviceid = DEVICEID

    @HeaderParam(name = "Accept")
    private val accept = ACCEPT

    @HeaderParam(name = "Cache-Control")
    private val cacheControl = CACHECONTROL

    @HeaderParam(name = "Accept-Language")
    private val acceptlanguage = ACCEPT_LANGUAGE

    @HeaderParam(name = "hunterid")
    private var hunterid: String? = null

    @HeaderParam(name = "password")
    private var password: String? = null


    constructor(
        hunterid: String,
        password: String,
        listener: Response.Listener<ParsedResponse<WildResponse>>,
        errorListener: Response.ErrorListener
    ) : super(listener, errorListener) {
        this.hunterid = hunterid
        this.password = password
    }

    constructor(hunterid: String, password: String) {
        this.hunterid = hunterid
        this.password = password
    }
}