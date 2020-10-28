package com.example.testzone.devbyte.worker

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.testzone.devbyte.database.VideosDatabase
import com.example.testzone.devbyte.repository.VideosRepository
import timber.log.Timber

class RefreshDataWorker(
    appContext: Context, params: WorkerParameters
) : CoroutineWorker(appContext, params) {
    companion object {
        const val WORK_NAME = "com.example.testzone.devbyte.worker.RefreshDataWorker"
    }
    override suspend fun doWork(): Result {
        val repository = VideosRepository(
            VideosDatabase.instance(applicationContext)
        )
        try {
            repository.refreshVideos()
            Timber.e("Work request for sync is run")
        }catch (e: Exception) {
            return Result.retry()
        }
        return Result.success()
    }
}