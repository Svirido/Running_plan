package com.svirido.running_plan.ui

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.svirido.running_plan.databinding.ActivityGoalBinding

class GoalActivity : AppCompatActivity() {

    lateinit var binding: ActivityGoalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGoalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPreferencesResult = getSharedPreferences("goal", Context.MODE_PRIVATE)
        val sharedPreferencesData = getSharedPreferences("data", Context.MODE_PRIVATE)

        val goal = sharedPreferencesResult.getInt("goal", 0)
        val data = sharedPreferencesData.getString("data", "00.00.00")

        binding.resultTextView.text = goal.toString()
        binding.dataTextView.text = data.toString()

        binding.updateButton.setOnClickListener {
            val result = binding.resultEditTextText.text.toString().toInt()
            val prefEditor: SharedPreferences.Editor = sharedPreferencesResult.edit()
            val newGoal = goal + result
            prefEditor.putInt("goal", newGoal)
            prefEditor.apply()

            val data = binding.dataeEditTextText.text.toString()
            val prefEditorData: SharedPreferences.Editor = sharedPreferencesData.edit()
            prefEditorData.putString("data", data)
            prefEditorData.apply()

            binding.resultTextView.text = sharedPreferencesResult.getInt("goal", 0).toString()
            binding.dataTextView.text = data

        }
    }
}