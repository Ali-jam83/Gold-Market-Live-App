package com.example.gold_price_app.ui

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gold_price_app.R
import com.example.gold_price_app.adapter.RecycleAdapter
import com.example.gold_price_app.databinding.ActivityMainBinding
import com.example.gold_price_app.remote.gold.GoldRepository
import com.example.gold_price_app.remote.gold.GoldResponse
import com.example.gold_price_app.remote.model.gold.Content
import com.example.gold_price_app.remote.model.gold.GoldModel
import com.example.gold_price_app.PersianDate

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var gold = ArrayList<Content>()
    private var currency = ArrayList<Content>()
    private var cryptocurrency = ArrayList<Content>()
    private var time = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


       /* TimeRepository.instance.getDate(
            object : TimeResponse {
                override fun onSuccess(date: DateModel) {
                    val time = date.date
                    val text = "${time.timel} ${time.timej} ${time.timeF} ${time.timeY}"
                    binding.textView.text = text
                }

                override fun onNotSuccess(massage: String) {
                    Toast.makeText(this@MainActivity, massage, Toast.LENGTH_SHORT).show()
                }

                override fun onFailure(massage: String) {
                    Toast.makeText(this@MainActivity, massage, Toast.LENGTH_SHORT).show()
                }

            }
        )*/
        val date= PersianDate()
binding.textView.text="${date.strWeekDay} ${date.day} ${date.strMonth} ${date.year}"

        getPrice()

        binding.recycleView.layoutManager =
            LinearLayoutManager(this, RecyclerView.VERTICAL, false)



        binding.txtDigit.setOnClickListener {
            binding.txtDigit.setTextColor(Color.parseColor("#E7C376"))
            binding.btnTala.setTextColor(Color.parseColor("#787879"))
            binding.btnArs.setTextColor(Color.parseColor("#787879"))
            setDataRecycle(cryptocurrency, arrayListOf(R.drawable.bitcoin,R.drawable.tether))

        }
        binding.btnTala.setOnClickListener {
            binding.btnTala.setTextColor(Color.parseColor("#E7C376"))
            binding.txtDigit.setTextColor(Color.parseColor("#787879"))
            binding.btnArs.setTextColor(Color.parseColor("#787879"))
            setDataRecycle(gold, arrayListOf(R.drawable.ic_18,R.drawable.ic_24,R.drawable.seke
                ,R.drawable.seke,R.drawable.seke))

        }
        binding.btnArs.setOnClickListener {
            binding.btnArs.setTextColor(Color.parseColor("#E7C376"))
            binding.txtDigit.setTextColor(Color.parseColor("#787879"))
            binding.btnTala.setTextColor(Color.parseColor("#787879"))
            setDataRecycle(currency, arrayListOf(R.drawable.dollar,R.drawable.erou,R.drawable.icons8,R.drawable.pound))

        }

    }

    private fun setDataRecycle(data: ArrayList<Content>,idIcon: ArrayList<Int>) {
        binding.recycleView.adapter = RecycleAdapter( data ,idIcon)
    }

    private fun getPrice() {
        GoldRepository.instance.getPrice(
            object : GoldResponse {
                override fun onSuccess(date: GoldModel) {
                    gold.addAll(date.data.golds)
                    currency.addAll(date.data.currencies)
                    cryptocurrency.addAll(date.data.cryptocurrencies)
                    time = date.last
                    binding.txtHours.text = time
                    setDataRecycle(gold, arrayListOf(R.drawable.ic_18,R.drawable.ic_24,R.drawable.seke
                    ,R.drawable.seke,R.drawable.seke))
                }

                override fun onNotSuccess(massage: String) {
                    Toast.makeText(this@MainActivity, massage, Toast.LENGTH_SHORT).show()

                }

                override fun onFailure(massage: String) {
                    Toast.makeText(this@MainActivity, massage, Toast.LENGTH_SHORT).show()

                }

            }
        )
    }


  /*  *//* این فانکشن به ما تاریخ دقیق و ساعت گوشی رو میده البته با استفاده از کلاس پرشین دیت *//*
    private fun getDate(): String {

        // با استفاده از کلاس PersianDate تاریخ شمسی و ساعت کنونی را بدست می آوریم
        val date = PersianDate()

        // این کد تاریخ شمسی فعلی را به رشته تبدیل میکند
        val currentDate = "${date.year}/${date.month}/${date.day}"
        // این کد ساعت و دقیقه و ثانیه فعلی را به رشته تبدیل میکند
        val currentTime = "${date.hour}:${date.min}:${date.second}"

        // در اینجا ساعت و تاریخ را به هم چسبانده و return میکنیم
        return "$currentDate | $currentTime"

    }*/


}