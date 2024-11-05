package com.example.lab2_dmd

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    private lateinit var tvResult: TextView
    private lateinit var tvResult2: TextView
    private lateinit var btnInfo: Button
    private lateinit var btnShare: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        tvResult = findViewById(R.id.result)
        tvResult2 = findViewById(R.id.resultString)
        btnInfo = findViewById(R.id.info)
        btnShare = findViewById(R.id.share)

        val result = intent.getStringExtra("result")
        tvResult.text = result

        val result2 = intent.getStringExtra("result2")
        tvResult2.text = result2

        btnInfo.setOnClickListener {
            val url = "https://en.wikipedia.org/wiki/Body_mass_index"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }

        btnShare.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND).apply{
                type = "text"
                putExtra(Intent.EXTRA_TEXT, "Share: $result, $result2")
            }
            startActivity(Intent.createChooser(shareIntent, "Share via"))
        }
    }
}
