package com.example.testzone.devbyte.worker

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.testzone.devbyte.database.Tracker
import com.example.testzone.devbyte.database.VideosDatabase
import com.example.testzone.devbyte.repository.VideosRepository
import timber.log.Timber

/**
 * This work request will run in the background
 * as long as the app is installed, even if the
 * app is not running
 */
class RefreshDataWorker(
    appContext: Context, params: WorkerParameters
) : CoroutineWorker(appContext, params) {
    companion object {
        const val WORK_NAME = "com.example.testzone.devbyte.worker.RefreshDataWorker"
    }
    override suspend fun doWork(): Result {
        val db = VideosDatabase.instance(applicationContext)
        val repository = VideosRepository(db)
        try {
            repository.refreshVideos()
            Timber.e("Work request for sync is run")
            val tracker = Tracker(
                time = System.currentTimeMillis(),
                randomInt = (0..Int.MAX_VALUE).random()
            )
            db.videoDao.insertTrackingWorkManager(tracker)
        }catch (e: Exception) {
            return Result.retry()
        }
        return Result.success()
    }
}