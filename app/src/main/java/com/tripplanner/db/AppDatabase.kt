package com.tripplanner.db

import android.app.Application
import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.tripplanner.application.MyApplication

@Database(entities = [Activity::class], version = 1,exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    companion object {
        private const val DATABASE_NAME = "database-Test"
        private val LOCK = Any()
        private lateinit var databaseInstance: AppDatabase
        private var INSTANCE: AppDatabase? = null
        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_notes_database")
                    .build()
                INSTANCE = instance

                return instance
            }
        }

        /*val dataBaseInstance: AppDatabase
            get() {
                if (!this::databaseInstance.isInitialized) {
                    synchronized(LOCK) {
                        databaseInstance = Room.databaseBuilder(
                            MyApplication.myApplication,
                            AppDatabase::class.java, DATABASE_NAME
                        ).allowMainThreadQueries().build()
                    }
                }
                return databaseInstance
            }*/
    }
    abstract fun activityDao(): ActivityDao
}

class ActivityRepository(val context: Context) {
    val database: AppDatabase by lazy { AppDatabase.getDatabase(context) }

    private val dataBaseInstance = database
    private val activityDao: ActivityDao = dataBaseInstance.activityDao()

    val allActivities: LiveData<List<Activity>> = activityDao.getAllActivities()

    suspend fun insert(activity: Activity) {
        activityDao.insert(activity)
    }

    suspend fun update(activity: Activity) {
        activityDao.update(activity)
    }

    suspend fun delete(activity: Activity) {
        activityDao.delete(activity)
    }
}