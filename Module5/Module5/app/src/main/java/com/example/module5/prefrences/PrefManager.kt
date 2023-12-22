package com.example.apiandroid

import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor

class PrefManager(context: Context) {
//class PrefManager(context: Callback<RegisterResponse>) {

    private val PREF_NAME =  "com.example.apiandroid"
    private val KEY_LOGIN = "login"
    private val KEY_USER = "user"


    private var preferences: SharedPreferences = context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE)
    private var editor:Editor = preferences.edit()

    fun Updatelogin(status:Boolean){
        editor.putBoolean(KEY_LOGIN,status)
        editor.commit()
    }

    fun getlogin():Boolean {
        return preferences.getBoolean(KEY_LOGIN, false)
    }

}
