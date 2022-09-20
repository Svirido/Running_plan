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
            val september9to19 = OneGoal(null, "September_9_to_19", 62)

            dataBaseHandler.addGoal(august)
            dataBaseHandler.addGoal(september1and2)
            dataBaseHandler.addGoal(noWatch)
            dataBaseHandler.addGoal(september9to19)

            editor.putBoolean("Key", true)
            editor.commit()
        }

        findDistance()
        findInterest()

        binding.updateButton.setOnClickListener {
            val data = binding.dataeEditTextText.text.toString()
            binding.dataeEditTextText.text = null
            val result = binding.resultEditTextText.text.toString().toInt()
            binding.resultEditTextText.text = null
            val oneGoal = OneGoal(null, data, result)
            dataBaseHandler.addGoal(oneGoal)
            findDistance()
            findInterest()
        }

        binding.plannedPercentageButton.setOnClickListener {
            findPlannedPercentage()
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

    private fun findPlannedPercentage(){
        val totalDays = 132.0
        val planPerDay = 1500.0 / 132.0
        val daysleft = binding.plannedPercentageEditTextText.text.toString().toInt() // 102 days - 20.09.2022
        val daysHavePassed = totalDays - daysleft.toDouble()
        var planed = ((planPerDay * daysHavePassed) / 1500.0) * 100.0
        planed = (planed * 10).roundToInt() / 10.00

        binding.plannedPercentageTextView.text = "$planed %"
    }

}