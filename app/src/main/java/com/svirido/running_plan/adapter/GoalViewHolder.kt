package com.svirido.running_plan.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.svirido.running_plan.base.OneGoal
import com.svirido.running_plan.databinding.ItemGoalBinding

class GoalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val binding = ItemGoalBinding.bind(itemView)

    fun bind(oneGoal: OneGoal) {
        binding.dateItemTextView.text = oneGoal.date
        binding.distanceItemTextView.text = oneGoal.distance.toString()
    }
}