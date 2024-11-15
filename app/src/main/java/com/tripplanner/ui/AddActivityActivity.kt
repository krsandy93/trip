package com.tripplanner.ui

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.tripplanner.R
import com.tripplanner.db.Activity
import com.tripplanner.db.ActivityRepository
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Locale

class AddActivityActivity : AppCompatActivity() {

    private lateinit var activityRepository: ActivityRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_activity)

        val etActivityName: EditText = findViewById(R.id.etActivityName)
        val etLocation: EditText = findViewById(R.id.etLocation)
        val etStartTime: EditText = findViewById(R.id.etStartTime)
        val etDuration: EditText = findViewById(R.id.etDuration)
        val btnSaveActivity: Button = findViewById(R.id.btnSaveActivity)

        activityRepository = ActivityRepository(this@AddActivityActivity)

        btnSaveActivity.setOnClickListener {
            val name = etActivityName.text.toString()
            val location = etLocation.text.toString()
            val startTime = SimpleDateFormat(
                "HH:mm",
                Locale.getDefault()
            ).parse(etStartTime.text.toString())?.time ?: 0L
            val duration = etDuration.text.toString().toLongOrNull()?.times(60000) ?: 0L

            if (name.isNotEmpty() && location.isNotEmpty() && startTime > 0 && duration > 0) {
                val activity = Activity(
                    name = name,
                    location = location,
                    startTime = startTime,
                    duration = duration
                )
                lifecycleScope.launch {
                    activityRepository.insert(activity)
                    finish()  // Close the activity after saving
                }
            } else {
                Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
