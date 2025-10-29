package com.example.gold_price_app.remote.model.gold

data class Data(
    val cryptocurrencies: List<Content>,
    val currencies: List<Content>,
    val golds: List<Content>
)
data class Content(
    val label: String,
    val price: Int
)
