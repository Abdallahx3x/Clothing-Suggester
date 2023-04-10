package com.example.clothing_suggestor.util

import android.content.Context
import android.content.SharedPreferences
import com.example.clothing_suggestor.ClotheImage
import com.google.gson.Gson

object PrefUtil {
    private var sharedPref: SharedPreferences?=null
    private const val SHARED_PREFS_NAME="myClothe"
    private const val CLOTHE_KEY="keyClothe"
    private const val TEMP_KEY="keyTemp"


    fun initPrefUtil(context: Context){
        sharedPref=context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)
    }
    var clotheList: List<ClotheImage>
        get() {
            val get = sharedPref?.getString(CLOTHE_KEY, null)
            return Gson().fromJson(get, Array<ClotheImage>::class.java).toList()
        }
        set(value){
            val edit=sharedPref?.edit()
            val myObjectListJson = Gson().toJson(value)
            edit?.putString(CLOTHE_KEY,myObjectListJson)?.apply()
        }


    var temperature: Float?
        get() = sharedPref?.getFloat(TEMP_KEY, 0F)
        set(value){
            val edit=sharedPref?.edit()
            edit?.putFloat(TEMP_KEY, value!!)?.apply()
        }

}