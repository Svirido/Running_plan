package com.svirido.running_plan.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.svirido.running_plan.TheDate
import com.svirido.running_plan.base.Workout
import com.svirido.running_plan.databinding.ItemTrainBinding
import com.svirido.running_plan.databinding.ItemWorkoutBinding

class TrainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val binding = ItemTrainBinding.bind(itemView)

    fun bind(workout: Workout) {
        binding.trainTextView.text = workout.train
        binding.dayWeekTextView.text = workout.dayWeek

    }

}