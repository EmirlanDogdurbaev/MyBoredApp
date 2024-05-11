package com.example.boredapp.api

import com.example.boredapp.models.Activity
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("activity")
    fun getActivity(
    ) : Call<Activity>
}