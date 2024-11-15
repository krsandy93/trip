package com.tripplanner.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tripplanner.R
import com.tripplanner.adapter.ActivityAdapter
import com.tripplanner.databinding.ActivityMainBinding
import com.tripplanner.db.ActivityRepository

class MainActivity : AppCompatActivity() {

    private lateinit var activityAdapter: ActivityAdapter
    private lateinit var activityRepository: ActivityRepository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvActivities: RecyclerView = findViewById(R.id.rvActivities)
        val btnAddActivity: Button = findViewById(R.id.btnAddActivity)

        activityRepository = ActivityRepository(this@MainActivity)

        activityAdapter = ActivityAdapter()
        rvActivities.layoutManager = LinearLayoutManager(this)
        rvActivities.adapter = activityAdapter

        activityRepository.allActivities.observe(this) {
            activityAdapter.submitList(it)
        }

        btnAddActivity.setOnClickListener {
            val intent = Intent(this, AddActivityActivity::class.java)
            startActivity(intent)
        }
    }
}