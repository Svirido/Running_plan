package com.svirido.running_plan.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.svirido.running_plan.R
import com.svirido.running_plan.WorkoutViewHolder
import com.svirido.running_plan.ui.listTrain

class TrainAdapter : RecyclerView.Adapter<TrainViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrainViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_train, parent, false)
        return TrainViewHolder(view)
    }

    override fun onBindViewHolder(holder: TrainViewHolder, position: Int) {
        holder.bind(listTrain[position])
    }

    override fun getItemCount(): Int {
        return listTrain.size
    }
}