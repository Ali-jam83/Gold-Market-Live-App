package com.example.gold_price_app.remote

import com.example.gold_price_app.remote.gold.GoldApiService
import com.example.gold_price_app.remote.time.TimeApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MaimRetrofitService {

    private const val url = "https://tools.daneshjooyar.com/api/v1/"

private val retrofit=Retrofit.Builder()
    .baseUrl(url)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

    val timeApiService:TimeApiService= retrofit.create(TimeApiService::class.java)


    val goldApiService:GoldApiService= retrofit.create(GoldApiService::class.java)
}