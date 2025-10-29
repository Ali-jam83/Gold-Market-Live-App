package com.example.gold_price_app.ui

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.gold_price_app.R
import com.example.gold_price_app.databinding.ActivityFullBinding

class FullActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFullBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFullBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_full)


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {


            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            val attrib = window.attributes
            attrib.layoutInDisplayCutoutMode =
                WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES

        }
        else {

            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )

        }



        Handler(Looper.getMainLooper()).postDelayed({


            val intent = Intent(this@FullActivity, MainActivity::class.java)
            startActivity(intent)


            finish()

        }, 3000)


    }


}
