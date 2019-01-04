package com.plixapp.czirjak.plixapp.webservice

import android.content.Context
import com.plixapp.czirjak.plixapp.login.requests.LoginResponse
import com.plixapp.czirjak.plixapp.login.requests.LoginRequest
import com.plixapp.czirjak.plixapp.wilds.model.Wild
import com.plixapp.czirjak.plixapp.wilds.model.WildRealmModel
import com.plixapp.czirjak.plixapp.wilds.requests.GetWildsRequest
import com.plixapp.czirjak.plixapp.wilds.requests.WildResponse
import com.rainy.networkhelper.future.ExecutionFuture
import io.realm.Realm
import io.realm.RealmConfiguration

import java.util.stream.Collectors
import java.util.stream.Stream

class WildsService {

    fun cleanDatabase() {
        Realm.deleteRealm(null!!)
    }

    fun getWilds(hunter: String, password: String, context: Context): ExecutionFuture<WildResponse> {
        return GetWildsRequest(hunter, password).getParsedFuture(context)
    }

    fun getWildsAndSaveToDatabase(hunter: String, password: String, context: Context): ExecutionFuture<WildResponse> {
        return object : ExecutionFuture<WildResponse>() {
            override fun execute(timeoutMs: Long?): WildResponse {
                //WildResponse responseDto = new LoginFuture(new LoginRequest(localStorage, username, generateAuthKey(username, password)).getParsedFuture()).get();
                val wildResponse = GetWildsRequest(hunter, password).getParsedFuture(context).get()
                val realm = Realm.getDefaultInstance()
                realm.beginTransaction()
                val wildList = arrayListOf<WildRealmModel>()
                for (it in wildResponse.wildsList?.wilds!!) {
                    val wildRealmModel = WildRealmModel()
                    //wildRealmModel.id = it.id
                    wildRealmModel.name = it.name_sk
                    wildList.add(wildRealmModel)
                    //realm.copyToRealm(wildRealmModel)
                }
                realm.copyToRealm(wildList)
                realm.commitTransaction()
                return wildResponse
            }
        }
    }

    fun getWildsFromDtabase(): List<Wild>? {
        return null
    }
}
