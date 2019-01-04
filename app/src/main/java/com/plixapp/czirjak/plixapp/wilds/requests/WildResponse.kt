package com.plixapp.czirjak.plixapp.wilds.requests

import com.google.gson.annotations.SerializedName
import com.plixapp.czirjak.plixapp.wilds.model.WildsList

class WildResponse {

    @SerializedName(value = "data")
    var wildsList: WildsList? = null
}
