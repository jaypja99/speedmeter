package com.example.speedmeter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import app.rive.runtime.kotlin.RiveAnimationView

class MainActivity : AppCompatActivity() {

    var progress1= 10F;
    var buttonIncrement: Button? = null
    var buttonDecrement: Button? = null
    var textView: TextView? = null

    private val animationView by lazy(LazyThreadSafetyMode.NONE) {
        findViewById<RiveAnimationView>(R.id.my_rive_animation)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonDecrement = findViewById<View>(R.id.button_decr) as Button
        buttonIncrement = findViewById<View>(R.id.button_incr) as Button
        textView = findViewById<View>(R.id.speedtext) as TextView




        object : CountDownTimer(99999999, 70) {
            override fun onTick(millisUntilFinished: Long) {

                if (progress1 < 100F) {
                    progress1= progress1+1
                    textView!!.text = progress1.toInt().toString()
                    Log.d("progress",progress1.toString())
                }
                animationView.setNumberState("right1", "Number 1", progress1)
                animationView.setNumberState("lefttop1", "left1", progress1)
                animationView.setNumberState("leftbottom1", "bottom1", progress1)

            }

            override fun onFinish() {
            }
        }.start()



        buttonIncrement!!.setOnClickListener { // if progress is less than or equal
            // to 90% then only it can be increased
            if (progress1 <= 90) {
                progress1 += 10

            }
        }

        // when clicked on buttonIncrement progress in decreased by 10%
        buttonDecrement!!.setOnClickListener { // If progress is greater than
            // 10% then only it can be decreased
            if (progress1 >= 10) {
                progress1 -= 10

            }
        }
    }



    }
