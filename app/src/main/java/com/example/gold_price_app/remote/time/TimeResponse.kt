package com.example.gold_price_app.remote.time

import com.example.gold_price_app.remote.model.time.DateModel

interface TimeResponse {

    fun onSuccess(date: DateModel)
    fun onNotSuccess(massage: String)
    fun onFailure(massage: String)
}