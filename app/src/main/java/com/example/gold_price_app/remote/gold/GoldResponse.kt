package com.example.gold_price_app.remote.gold

import com.example.gold_price_app.remote.model.gold.GoldModel
import com.example.gold_price_app.remote.model.time.DateModel

interface GoldResponse {

    fun onSuccess(date: GoldModel)
    fun onNotSuccess(massage: String)
    fun onFailure(massage: String)
}