package com.example.boredapp.api

import android.content.Context
import android.widget.Toast
import okhttp3.*
import java.io.IOException

object PrefetchManager {

    private val client = OkHttpClient()

    fun prefetchUrl(url: String) {
        val request = Request.Builder()
            .url(url)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                throw Exception("Невозможно пройти по ссылке")
            }

            override fun onResponse(call: Call, response: Response) {
                response.close()
            }
        })
    }
}
