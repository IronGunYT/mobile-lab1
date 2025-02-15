package com.example.task2_2

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonShow: Button = findViewById(R.id.btnSubscribe)
        val textViewInfo: TextView = findViewById(R.id.textViewInfo)

        buttonShow.setOnClickListener {
            if (textViewInfo.visibility == View.VISIBLE) {
                textViewInfo.visibility = View.GONE
                buttonShow.text = "Подписаться"
            } else {
                textViewInfo.visibility = View.VISIBLE
                buttonShow.text = "Скрыть"
            }
        }
    }
}
