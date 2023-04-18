package com.example.projectworkaprilkumak.sharedPreferences

import android.content.Context
import android.content.SharedPreferences

class MySharedPreferences {
    companion object{
        private var mySharedPreferences = MySharedPreferences()
        private var splash: SharedPreferences? = null
        private lateinit var editor: SharedPreferences.Editor

        fun getInstance(context: Context) : MySharedPreferences{
            if (splash == null){
                splash = context.getSharedPreferences("context", Context.MODE_PRIVATE)
            }
            return mySharedPreferences
        }
        fun getStatus() : Boolean{
            return splash!!.getBoolean("status", false)
        }
        fun setStatus(status:Boolean) {
            editor = splash!!.edit()
            editor.putBoolean("status", status).apply()
        }
    }
}