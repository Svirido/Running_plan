package com.svirido.running_plan.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.svirido.running_plan.R
import com.svirido.running_plan.base.Workout
import com.svirido.running_plan.databinding.ActivityAddTrainBinding
import java.io.Serializable

class AddTrainActivity : AppCompatActivity() {

    lateinit var binding: ActivityAddTrainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddTrainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var type = "easy"
        val types = arrayOf("easy", "job", "relax", "rLong")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, types)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.typeSpinner.adapter = adapter

        binding.typeSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
                type = types[position]
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }

        binding.addOneTrainButton.setOnClickListener {

            val date = binding.dateEditTextText.text.toString()
            val dayWeek = binding.dayWeekEditTextText.text.toString()
            val train = binding.trainEditTextText.text.toString()
            val description = binding.descriptionEditTextText.text.toString()

            val newTrain = Workout(null, type, date, dayWeek, train, description, "")

            val intent = Intent(this, TrainActivity::class.java)
            intent.putExtra("newTrain", newTrain as Serializable)
            startActivity(intent)
        }
    }


}