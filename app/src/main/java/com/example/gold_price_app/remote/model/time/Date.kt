package com.example.gold_price_app.remote.model.time

import com.google.gson.annotations.SerializedName

data class Date(
    @SerializedName("F") val timeF: String,
    @SerializedName("Y") val timeY: String,
    @SerializedName("j") val timej: String,
    @SerializedName("l") val timel: String,

    )