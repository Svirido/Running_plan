package com.svirido.running_plan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.svirido.running_plan.databinding.ActiviryWorkoutBinding

class WorkoutActivity : AppCompatActivity() {

    lateinit var binding: ActiviryWorkoutBinding

    private var adapter = WorkoutAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActiviryWorkoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recylcerView.layoutManager = LinearLayoutManager(this)
        binding.recylcerView.adapter = adapter

    }
}