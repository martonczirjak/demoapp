package com.plixapp.czirjak.plixapp.wilds

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.Telephony.Carriers.PASSWORD
import android.widget.Toast
import com.android.volley.Response

import com.plixapp.czirjak.plixapp.R
import com.plixapp.czirjak.plixapp.databinding.ActivityLoginBinding
import com.plixapp.czirjak.plixapp.databinding.ActivityWildsBinding
import com.plixapp.czirjak.plixapp.login.requests.LoginRequest
import com.plixapp.czirjak.plixapp.webservice.WildsService
import com.plixapp.czirjak.plixapp.wilds.model.WildRealmModel
import com.plixapp.czirjak.plixapp.wilds.requests.GetWildsRequest
import io.realm.Realm

/**
 * A login screen that offers login via email/password.
 */
class WildsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWildsBinding
    private val wildService = WildsService()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_wilds)
     /*   wildService.getWildsAndSaveToDatabase(".", PASSWORD, this).enqueue({ succesResponse->
            Toast.makeText(this, "SIKERULT", Toast.LENGTH_SHORT).show()
        }, {
            Toast.makeText(this, "NEMSIKERULT", Toast.LENGTH_SHORT).show()
        })*/
        wildService.getWilds(".", PASSWORD, this).enqueue({ succesResponse->
            Toast.makeText(this, "SIKERULT", Toast.LENGTH_SHORT).show()
            val defaultInstance = Realm.getDefaultInstance()
            defaultInstance.beginTransaction()
            val wildRealmModel = WildRealmModel()
            wildRealmModel.id = 2
                wildRealmModel.name="fdgdsf"
            defaultInstance.insert(wildRealmModel)
            defaultInstance.commitTransaction()
            Toast.makeText(this, "SIKERULT MENTENI", Toast.LENGTH_SHORT).show()
        }, {
            Toast.makeText(this, "NEMSIKERULT", Toast.LENGTH_SHORT).show()
        })

     /*   GetWildsRequest(
            "-",
            "--",
            Response.Listener { succesResponse ->
                Toast.makeText(this, "LETÖLTVE.", Toast.LENGTH_LONG).show()
            },
            Response.ErrorListener { response ->
                Toast.makeText(this, R.string.download_error, Toast.LENGTH_LONG).show()
            }).send(this)
*/

    }
}
