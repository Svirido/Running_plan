package com.svirido.running_plan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.svirido.running_plan.databinding.ActivityMainBinding
import com.svirido.running_plan.ui.TrainActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = Intent(this, TrainActivity::class.java)
        startActivity(intent)

//        binding.buttonCalendar.setOnClickListener {
//            val intent = Intent(this, CalendarActivity::class.java)
//            startActivity(intent)
//        }
//
//        binding.buttonWorkout.setOnClickListener {
//            val intent = Intent(this, WorkoutActivity::class.java)
//            startActivity(intent)
//        }


    }
}