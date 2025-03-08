package com.example.filipinofeastfoodtruck2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Status Elements
        val statusText: TextView = findViewById(R.id.statusText)
        val statusIndicator: ImageView = findViewById(R.id.statusIndicator)
        val countdownText: TextView = findViewById(R.id.countdownTextView)

        // Get current time (24-hour format)
        val currentHour = java.util.Calendar.getInstance().get(java.util.Calendar.HOUR_OF_DAY)

        // Business hours logic (Example: Open from 10 AM - 8 PM)
        if (currentHour in 10..20) {
            statusText.text = "Open Now"
            statusIndicator.setImageResource(R.drawable.greenbutton)
            countdownText.text = "We are Open!"
        } else {
            statusText.text = "Closed"
            statusIndicator.setImageResource(R.drawable.redbutton)
            countdownText.text = "Opens at 10:00 AM"
        }

        // Buttons Navigation
        val menuButton: Button = findViewById(R.id.menuButton)
        val hoursLocationButton: Button = findViewById(R.id.hoursLocationButton)

        menuButton.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }

        hoursLocationButton.setOnClickListener {
            val intent = Intent(this, HoursLocationActivity::class.java)
            startActivity(intent)
        }
    }
}
