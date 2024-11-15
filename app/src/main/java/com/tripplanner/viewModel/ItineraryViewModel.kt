package com.tripplanner.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.tripplanner.db.Activity
import com.tripplanner.db.ActivityDao
import com.tripplanner.db.AppDatabase
import kotlinx.coroutines.launch

/*
class ItineraryViewModel(application: Application) : AndroidViewModel(application) {
    private val dataBaseInstance = AppDatabase
    private val activityDao: ActivityDao = dataBaseInstance.activityDao()
    val activities: LiveData<List<Activity>> = activityDao.getAllActivities()

    fun addActivity(activity: Activity) {
        viewModelScope.launch {
            activityDao.insert(activity)
        }
    }

    fun removeActivity(activity: Activity) {
        viewModelScope.launch {
            activityDao.delete(activity)
        }
    }

    fun updateActivity(activity: Activity) {
        viewModelScope.launch {
            activityDao.update(activity)
        }
    }
}

*/
