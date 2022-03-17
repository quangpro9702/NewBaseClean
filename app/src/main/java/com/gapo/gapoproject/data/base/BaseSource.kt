package com.gapo.gapoproject.data.base

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException

open class BaseSource<out T> {
    inline fun <reified T> getData(context: Context,source :String): T {
        lateinit var jsonString: String
        try {
            jsonString = context.assets.open(source)
                .bufferedReader()
                .use { it.readText() }
        } catch (ioException: IOException) {
            Log.d("getData", ioException.message.toString())
        }

        val data = object : TypeToken<T>() {}.type
        return Gson().fromJson(jsonString, data)
    }
}