package com.tripplanner.jUnit

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.tripplanner.db.Activity
import com.tripplanner.db.ActivityDao
import com.tripplanner.db.AppDatabase


/*@RunWith(JUnit4::class)
class ItineraryViewModelTest {

    private lateinit var activityDao: ActivityDao
    private lateinit var db: AppDatabase
    private lateinit var viewModel: ItineraryViewModel

    @Before
    fun setup() {
        db = Room.inMemoryDatabaseBuilder(ApplicationProvider.getApplicationContext(), AppDatabase::class.java)
            .allowMainThreadQueries()
            .build()
        activityDao = db.activityDao()
        viewModel = ItineraryViewModel(ApplicationProvider.getApplicationContext())
    }

    @Test
    fun testAddActivity() {
        val activity = Activity(name = "Test Activity", location = "Test Location", startTime = 1234567890, duration = 60)
        viewModel.addActivity(activity)
        val activities = activityDao.getAllActivities().getOrAwaitValue()
        assertTrue(activities.contains(activity))
    }
}*/
