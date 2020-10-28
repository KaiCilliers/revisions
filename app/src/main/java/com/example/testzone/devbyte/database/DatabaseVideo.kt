package com.example.testzone.devbyte.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.testzone.devbyte.domain.DevByteVideo

/**
 * Used to check if workmanager did indeed run at set intervals
 * without having to rely on the Logcat
 */
@Entity
data class Tracker(
    @PrimaryKey
    val time: Long,
    val randomInt: Int
)

/**
 * DatabaseVideo represents a video entity in the database.
 */
@Entity
data class DatabaseVideo constructor(
    @PrimaryKey
    val url: String,
    val updated: String,
    val title: String,
    val description: String,
    val thumbnail: String)
/**
 * Map DatabaseVideos to domain entities
 */
fun List<DatabaseVideo>.asDomainModel(): List<DevByteVideo> {
    return map {
        DevByteVideo(
            url = it.url,
            title = it.title,
            description = it.description,
            updated = it.updated,
            thumbnail = it.thumbnail)
    }
}