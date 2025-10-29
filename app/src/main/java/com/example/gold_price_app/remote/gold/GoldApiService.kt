package com.example.gold_price_app.remote.gold

import com.example.gold_price_app.remote.model.gold.GoldModel
import retrofit2.Call
import retrofit2.http.GET

interface GoldApiService {
    @GET("currencies")
    fun getGold():Call<GoldModel>
}