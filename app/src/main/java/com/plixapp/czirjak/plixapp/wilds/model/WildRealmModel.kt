package com.plixapp.czirjak.plixapp.wilds.model

import io.realm.RealmModel
import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required

class WildRealmModel : RealmModel{

    @Required
    @PrimaryKey
    var id: String? = null

    var name: String? = null

    
}
