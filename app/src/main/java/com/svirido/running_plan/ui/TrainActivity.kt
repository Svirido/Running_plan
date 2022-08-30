package com.svirido.running_plan.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.svirido.running_plan.adapter.TrainAdapter
import com.svirido.running_plan.base.Workout
import com.svirido.running_plan.data.DataBaseHandler
import com.svirido.running_plan.databinding.ActivityTrainBinding

var listTrain = arrayListOf<Workout>() // todo

class TrainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTrainBinding

    private var adapter = TrainAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTrainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recylcerViewTrain.layoutManager = LinearLayoutManager(this)
        binding.recylcerViewTrain.adapter = adapter

        val easy = "easy"
        val job = "job"
        val relax = "relax"
        val rLong = "rLong"

        val train30082022 = Workout(null, job, "30.08.2022", "Tuesday", "5-3-2-1 / 800", "", "")
        val train31082022 = Workout(null, easy, "31.08.2022", "Wednesday", "20 km.", "", "")
        val train01092022 = Workout(null, easy, "01.09.2022", "Thursday", "20 km.", "", "")
        val train02092022 = Workout(null, job, "02.09.2022", "Friday", "Temp 12 km.", "", "")
        val train03092022 = Workout(null, easy, "03.09.2022", "Saturday", "22 km.", "", "")
        val train04092022 = Workout(null, rLong, "04.09.2022", "Sunday", "35 km", "", "")

        val dataBaseHandler = DataBaseHandler(this)
        dataBaseHandler.addTrain(train30082022)
        dataBaseHandler.addTrain(train31082022)
        dataBaseHandler.addTrain(train01092022)
        dataBaseHandler.addTrain(train02092022)
        dataBaseHandler.addTrain(train03092022)
        dataBaseHandler.addTrain(train04092022)

        listTrain = dataBaseHandler.getAllTrain() as ArrayList<Workout>
    }
}