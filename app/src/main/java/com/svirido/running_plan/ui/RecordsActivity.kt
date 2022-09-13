package com.svirido.running_plan.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.svirido.running_plan.adapter.GoalAdapter
import com.svirido.running_plan.data.GoalDataBaseHandler
import com.svirido.running_plan.databinding.ActivityRecordsBinding

class RecordsActivity : AppCompatActivity() {

    lateinit var binding: ActivityRecordsBinding

    private var adapter = GoalAdapter()

    private val dataBaseHandler = GoalDataBaseHandler(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecordsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.goCoalActivityButton.setOnClickListener {
            val intent = Intent(this, GoalActivity::class.java)
            startActivity(intent)
        }

        binding.recyclerViewRecord.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewRecord.adapter = adapter


    }
}