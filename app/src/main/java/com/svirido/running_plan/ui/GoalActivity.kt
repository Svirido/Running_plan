package com.svirido.running_plan.ui

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.svirido.running_plan.databinding.ActivityGoalBinding

class GoalActivity : AppCompatActivity() {

    lateinit var binding: ActivityGoalBinding

    @SuppressLint("CommitPrefEdits")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGoalBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val sharedPreferencesResult = getSharedPreferences("result", Context.MODE_PRIVATE)
        binding.resultTextView.text = sharedPreferencesResult.getString("result", "000")


        binding.updateButton.setOnClickListener {
            val goal = binding.resultEditTextText.text.toString()
            sharedPreferencesResult.edit().putString("result", goal)

        }


    }
}