package com.plixapp.czirjak.plixapp.wilds.model

import io.realm.RealmModel
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required

class WildRealmModel : RealmObject() {
    @PrimaryKey
    var id: Int? = null
    var name: String? = null
}
