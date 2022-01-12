package com.neppplus.pythonapipractice_20220110.utils

import android.content.Context

class ContextUtil {

    companion object {

        private val prefName = "PythonAPIPracticePref"

        private val USER_ID = "USER_ID"

        fun setUserId(context: Context, userId: Int) {

            val pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE)
            pref.edit().putInt(USER_ID,  userId).apply()

        }

        fun getUserId(context: Context) : Int {

            val pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE)
            return  pref.getInt(USER_ID, -1)

        }

    }

}