package com.svirido.running_plan.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.svirido.running_plan.R
import com.svirido.running_plan.TheDate
import com.svirido.running_plan.base.Workout
import com.svirido.running_plan.databinding.ItemTrainBinding
import com.svirido.running_plan.databinding.ItemWorkoutBinding

class TrainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val binding = ItemTrainBinding.bind(itemView)

    fun bind(workout: Workout) {

        binding.trainTextView.text = workout.train
        binding.dayWeekTextView.text = workout.dayWeek
        binding.dateTextView.text = workout.date

        when (workout.type) {
            "easy" -> binding.typeImageView.setImageResource(R.drawable.easy)
            "job" -> binding.typeImageView.setImageResource(R.drawable.job)
            "relax" -> binding.typeImageView.setImageResource(R.drawable.relax)
            "rLong" -> binding.typeImageView.setImageResource(R.drawable.rlong)
        }
    }
}