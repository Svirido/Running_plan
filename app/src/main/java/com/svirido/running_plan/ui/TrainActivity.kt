package com.svirido.running_plan.ui

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.svirido.running_plan.adapter.TrainAdapter
import com.svirido.running_plan.base.OneGoal
import com.svirido.running_plan.base.Workout
import com.svirido.running_plan.data.DataBaseHandler
import com.svirido.running_plan.databinding.ActivityTrainBinding
import java.io.Serializable

var listTrain = arrayListOf<Workout>()

class TrainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTrainBinding

    private var adapter = TrainAdapter()

    private val dataBaseHandler = DataBaseHandler(this)

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

        var sharedPreference2: SharedPreferences? = null
        sharedPreference2 = getSharedPreferences("Key2", Context.MODE_PRIVATE)

        val check2: Boolean = sharedPreference2.getBoolean("Key2", false)
        val editor2 = sharedPreference2.edit()

        if (!check2) {
            val train01092022 = Workout(null, easy, "01.09.2022", "Thursday", "20 km.", "", "")
            val train02092022 = Workout(null, job, "02.09.2022", "Friday", "Temp 12 km.", "", "")
            val train03092022 = Workout(null, easy, "03.09.2022", "Saturday", "22 km.", "", "")
            val train04092022 = Workout(null, rLong, "04.09.2022", "Sunday", "35 km", "", "")

            dataBaseHandler.addTrain(train01092022)
            dataBaseHandler.addTrain(train02092022)
            dataBaseHandler.addTrain(train03092022)
            dataBaseHandler.addTrain(train04092022)

            editor2.putBoolean("Key2", true)
            editor2.commit()
        }

        val newTrain = intent.getSerializableExtra("newTrain") as? Serializable
        if (newTrain != null) {
            dataBaseHandler.addTrain(newTrain as Workout)
        }

        listTrain = dataBaseHandler.getAllTrain() as ArrayList<Workout>

        binding.addTrainButton.setOnClickListener {
            val intent = Intent(this, AddTrainActivity::class.java)
            startActivity(intent)
        }

    }

}