package com.tripplanner.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ActivityDao {
    @Insert
    suspend fun insert(activity: Activity)

    @Update
    suspend fun update(activity: Activity)

    @Delete
    suspend fun delete(activity: Activity)

    @Query("SELECT * FROM activities ORDER BY startTime ASC")
    fun getAllActivities(): LiveData<List<Activity>>
}