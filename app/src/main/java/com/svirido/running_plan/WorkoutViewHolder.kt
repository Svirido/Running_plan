package com.svirido.running_plan

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.svirido.running_plan.databinding.ItemWorkoutBinding

class WorkoutViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val binding = ItemWorkoutBinding.bind(itemView)
    fun bind(theDate: TheDate) {
        binding.textView4.text = theDate.dayOfMonth.toString()
    }

}