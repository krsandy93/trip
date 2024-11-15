package com.tripplanner.adapter

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tripplanner.R
import com.tripplanner.databinding.ActivityItemBinding
import com.tripplanner.db.Activity
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class ActivityAdapter : ListAdapter<Activity, ActivityAdapter.ActivityViewHolder>(ActivityDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivityViewHolder {
        val binding = ActivityItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ActivityViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ActivityViewHolder, position: Int) {
        val activity = getItem(position)
        holder.bind(activity)
    }

    class ActivityViewHolder(private val binding: ActivityItemBinding) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(activity: Activity) {
            binding.activityName.text = "Name: ${activity.name}"
            binding.activityLocation.text = "Location: ${activity.location}"
            binding.activityTime.text = "Time: ${SimpleDateFormat("HH:mm", Locale.getDefault()).format(Date(activity.startTime))}"
            binding.tvActivityDuration.text = "Duration: ${activity.duration / 60000} minutes"

            // Add logic to show overlapping activity indicator here
        }
    }

    class ActivityDiffCallback : DiffUtil.ItemCallback<Activity>() {
        override fun areItemsTheSame(oldItem: Activity, newItem: Activity): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Activity, newItem: Activity): Boolean {
            return oldItem == newItem
        }
    }
}

