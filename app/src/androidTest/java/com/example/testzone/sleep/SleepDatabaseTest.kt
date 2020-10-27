package com.example.testzone.sleep

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.testzone.sleep.database.SleepDao
import com.example.testzone.sleep.database.SleepDatabase
import com.example.testzone.sleep.database.SleepNightEntity
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class SleepDatabaseTest {
    private lateinit var sleepDao: SleepDao
    private lateinit var db: SleepDatabase

    @Before
    fun createDB() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        // Using an in-memory database because the information stored here disappears when the
        // process is killed.
        db = Room.inMemoryDatabaseBuilder(context, SleepDatabase::class.java)
            // Allow main thread queries, just for testing
            .allowMainThreadQueries()
            .build()
        sleepDao = db.sleepDao
    }

    @After
    @Throws(IOException::class)
    fun closeDb() = db.close()

    @Test
    fun insert_and_get_a_night() {
        val night = SleepNightEntity()
        sleepDao.insert(night)
        val tonight = sleepDao.tonight()
        assertEquals(tonight?.sleepQuality, -1)
    }

    fun update_a_night() {
        val night = SleepNightEntity()
        sleepDao.insert(night)
        night.sleepQuality = 5
        night.endTimeMilli = 70000
        sleepDao.update(night)
        val tonight = sleepDao.night(night.id)
        assertEquals(
            tonight?.sleepQuality, 5
        )
        assertEquals(
            tonight?.endTimeMilli,
            70000
        )

    }

    fun get_all_the_nights() {
        sleepDao.insert(SleepNightEntity())
        sleepDao.insert(SleepNightEntity())
        sleepDao.insert(SleepNightEntity())
        val all = sleepDao.all()
        assertEquals(all.value != null, true)
    }

    @Test
    fun clear_the_database() {
        sleepDao.insert(SleepNightEntity())
        sleepDao.insert(SleepNightEntity())
        sleepDao.clear()
        val tonight = sleepDao.tonight()
        assertEquals(tonight, null)
    }
}