package com.plixapp.czirjak.plixapp.wilds.requests;

import com.google.gson.annotations.SerializedName;

public class WildResponse {

    @SerializedName(value = "data")
    public WildsList wildsList;

    public WildResponse() {
    }
}
