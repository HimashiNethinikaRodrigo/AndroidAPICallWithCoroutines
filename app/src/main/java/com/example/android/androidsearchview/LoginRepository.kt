package com.example.android.androidsearchview

import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class LoginRepository {
    private val homeUrl = "https://sv443.net/jokeapi/v2/joke/Any"

    fun makeLoginRequest() {
        val url = URL(homeUrl)

        val httpURLConnection = url.openConnection() as? HttpURLConnection

        httpURLConnection?.run {
            requestMethod ="GET"

            setRequestProperty("Content-Type", "application/json; charset=UTF-8")
            setRequestProperty("Accept",  "application/json")
            doInput = true

            val collectionType = object : TypeToken<Home>(){}.type
            val home : Home = Gson().fromJson(InputStreamReader(inputStream), collectionType)

            Log.i("Response ", home.toString() )
        }
    }
}



sealed class Result<out R> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val exception: Exception) : Result<Nothing>()
}