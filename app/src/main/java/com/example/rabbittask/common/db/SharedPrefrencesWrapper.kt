package com.homyapplication.common.db

import android.content.SharedPreferences

class SharedPrefrencesWrapper(private var sharedPrefrence: SharedPreferences) {

    fun saveString(key: String, value: String) {
        sharedPrefrence.edit().putString(key, value).apply()
    }

    fun getString(key: String, defValue: String = ""): String {
        return sharedPrefrence.getString(key, defValue)!!
    }

    fun saveBool(key: String, value: Boolean) {
        sharedPrefrence.edit().putBoolean(key, value).apply()
    }

    fun getBool(key: String, defValue: Boolean= false): Boolean{
        return sharedPrefrence.getBoolean(key, defValue)
    }






}