package com.svirido.running_plan.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.svirido.running_plan.R
import com.svirido.running_plan.WorkoutAdapter
import com.svirido.running_plan.adapter.TrainAdapter
import com.svirido.running_plan.base.Workout
import com.svirido.running_plan.databinding.ActivityTrainBinding

var listTrain = arrayListOf<Workout>()

class TrainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTrainBinding

    private var adapter = TrainAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTrainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recylcerViewTrain.layoutManager = LinearLayoutManager(this)
        binding.recylcerViewTrain.adapter = adapter


        val train22082022 = Workout("Monday", "12 km.")
        val train23082022 = Workout("Tuesday", "6 по 1 000 через 400")
        val train24082022 = Workout("Wednesday", "12 km.")
        val train25082022 = Workout("Thursday", "16 km.")
        val train26082022 = Workout("Friday", "8 по 1 000 через 400")
        val train27082022 = Workout("Saturday", "25 km.")
        val train28082022 = Workout("Sunday", "Relaxation")

        listTrain.add(train22082022)
        listTrain.add(train23082022)
        listTrain.add(train24082022)
        listTrain.add(train25082022)
        listTrain.add(train26082022)
        listTrain.add(train27082022)
        listTrain.add(train28082022)

    }
}