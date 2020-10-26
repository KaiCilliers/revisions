package com.example.testzone.sleep.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface SleepDao {
    @Insert
    fun insert(night: SleepNightEntity)

    @Update
    fun update(night: SleepNightEntity)

    @Query("SELECT * FROM daily_sleep_quality_table WHERE id = :id")
    fun night(id: Long): SleepNightEntity?

    @Query("SELECT * FROM daily_sleep_quality_table")
    fun all(): LiveData<List<SleepNightEntity>>

    @Query("SELECT * FROM daily_sleep_quality_table ORDER BY id DESC LIMIT 1")
    fun latest(): SleepNightEntity?

    @Query("DELETE FROM daily_sleep_quality_table")
    fun clear()
}