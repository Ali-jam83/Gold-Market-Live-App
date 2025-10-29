package com.example.gold_price_app.remote.model.gold

import com.google.gson.annotations.SerializedName

data class GoldModel(
    val data: Data,
    @SerializedName("last_update") val last: String,
    val message: String,
    val source: String,
    val success: Int
)