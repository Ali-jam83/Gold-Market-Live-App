package com.example.gold_price_app.remote.time

import com.example.gold_price_app.remote.model.time.DateModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TimeApiService {


    @GET("data/now")
    fun getDate (
        @Query("short")short: Boolean
    ): Call<DateModel>
}