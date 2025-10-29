package com.example.gold_price_app.remote.gold

import com.example.gold_price_app.remote.MaimRetrofitService
import com.example.gold_price_app.remote.model.gold.GoldModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GoldRepository private constructor(){
    companion object {

        private var timeRepository: GoldRepository? = null

        val instance: GoldRepository
            get() {
                if (timeRepository == null) {
                    timeRepository = GoldRepository()
                }
                return timeRepository!!
            }
    }

    fun getPrice(
        goldResponse: GoldResponse
    ){
        MaimRetrofitService.goldApiService.getGold().enqueue(
            object : Callback<GoldModel>{
                override fun onResponse(call: Call<GoldModel>, response: Response<GoldModel>) {

                    if (response.isSuccessful){
                        goldResponse.onSuccess(response.body() as GoldModel)
                    }else{
                        goldResponse.onNotSuccess(response.message())
                    }
                }

                override fun onFailure(call: Call<GoldModel>, t: Throwable) {
                    goldResponse.onNotSuccess("ERROR : ${t.message}")

                }
            }
        )

    }
}