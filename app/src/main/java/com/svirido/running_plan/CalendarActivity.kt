package com.svirido.running_plan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.svirido.running_plan.databinding.ActivityCalendarBinding

var listTheDate = arrayListOf<TheDate>()

class CalendarActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCalendarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalendarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var theDate: TheDate

        binding.calendarView.setOnDateChangeListener { calendarView, year, month, dayOfMonth ->
            Log.d("calendar", " $year  $month  $dayOfMonth")
            theDate = TheDate(year, month, dayOfMonth)
            listTheDate.add(theDate)
        }

        binding.button1.setOnClickListener {
            binding.textView1.text = listTheDate[0].dayOfMonth.toString()
        }

        binding.button2.setOnClickListener {
            binding.textView2.text = listTheDate[1].dayOfMonth.toString()
        }



    }
}