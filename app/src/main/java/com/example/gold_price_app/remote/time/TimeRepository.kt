package com.example.gold_price_app.remote.time

import com.example.gold_price_app.remote.MaimRetrofitService
import com.example.gold_price_app.remote.model.time.DateModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TimeRepository private constructor(){
    companion object {

        private var timeRepository: TimeRepository? = null

        val instance: TimeRepository
            get() {
                if (timeRepository == null) {
                    timeRepository = TimeRepository()
                }
                return timeRepository!!
            }
    }

    fun getDate(
        timeResponse: TimeResponse
    ){
        MaimRetrofitService.timeApiService.getDate(true).enqueue(
            object : Callback<DateModel>{
                override fun onResponse(call: Call<DateModel>, response: Response<DateModel>) {

                    if (response.isSuccessful){
                        timeResponse.onSuccess(response.body() as DateModel)
                    }else{
                        timeResponse.onNotSuccess(response.message())
                    }
                }

                override fun onFailure(call: Call<DateModel>, t: Throwable) {
                    timeResponse.onNotSuccess("ERROR : ${t.message}")

                }
            }
        )

    }
}