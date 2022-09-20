package com.svirido.running_plan.ui

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.svirido.running_plan.base.OneGoal
import com.svirido.running_plan.data.GoalDataBaseHandler
import com.svirido.running_plan.databinding.ActivityGoalBinding
import kotlin.math.roundToInt

var goalsList = arrayListOf<OneGoal>()

class GoalActivity : AppCompatActivity() {

    private val dataBaseHandler = GoalDataBaseHandler(this)

    lateinit var binding: ActivityGoalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGoalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var sharedPreference: SharedPreferences? = null
        sharedPreference = getSharedPreferences("Key", Context.MODE_PRIVATE)

        val check: Boolean = sharedPreference.getBoolean("Key", false)
        val editor = sharedPreference.edit()

        if (!check) {
            val august = OneGoal(null, "August", 88)
            val september1and2 = OneGoal(null, "September_1_and_2", 11)
            val noWatch = OneGoal(null, "no watch", 36)
            dataBaseHandler.addGoal(august)
            dataBaseHandler.addGoal(september1and2)
            dataBaseHandler.addGoal(noWatch)
            editor.putBoolean("Key", true)
            editor.commit()
        }

        findDistance()
        findInterest()

        binding.updateButton.setOnClickListener {
            val data = binding.dataeEditTextText.text.toString()
            val result = binding.resultEditTextText.text.toString().toInt()
            val oneGoal = OneGoal(null, data, result)
            dataBaseHandler.addGoal(oneGoal)
            findDistance()
            findInterest()
        }

        binding.watchRecordsButton.setOnClickListener {
            val intent = Intent(this, RecordsActivity::class.java)
            startActivity(intent)
        }
    }

    private fun findDistance(): Int {
        var result = 0
        goalsList = dataBaseHandler.getAllOneGoal() as ArrayList<OneGoal>
        for (i in goalsList) {
            result += i.distance
        }
        binding.resultTextView.text = result.toString()
        return result
    }

    private fun findInterest() {
        var interest = (findDistance() / 1500.0) * 100.0
        interest = (interest * 10).roundToInt() / 10.0
        binding.interestTextView.text = "$interest %"

    }

}