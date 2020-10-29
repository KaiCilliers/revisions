package com.example.testzone

import android.app.Application
import android.os.Build
import androidx.work.*
import com.example.testzone.devbyte.database.DatabaseVideo
import com.example.testzone.devbyte.database.VideosDatabase
import com.example.testzone.devbyte.worker.RefreshDataWorker
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber
import java.util.concurrent.TimeUnit

class App : Application() {
    private val applicationScope by lazy { CoroutineScope(Dispatchers.Default) }
    override fun onCreate() {
        super.onCreate()
        delayedInit()
    }
    /**
     * Setup WorkManager background job to 'fetch' new network data daily.
     */
    private fun setupRecurringWork() {
//        val constraints = Constraints.Builder()
//            .setRequiredNetworkType(NetworkType.UNMETERED)
//            .setRequiresBatteryNotLow(true)
//            .setRequiresCharging(true)
//            .apply {
//                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                    setRequiresDeviceIdle(true)
//                }
//            }
//            .build()
        // WorkRequest with Worker
        val repeatingRequest = PeriodicWorkRequestBuilder<RefreshDataWorker>(
            repeatInterval = 15,
            repeatIntervalTimeUnit = TimeUnit.MINUTES)
            .build()
        Timber.e("Periodic Work request for sync is scheduled")
        WorkManager.getInstance().enqueueUniquePeriodicWork(
            RefreshDataWorker.WORK_NAME,
            ExistingPeriodicWorkPolicy.KEEP,
            repeatingRequest
        )
    }

    /**
     * Best Practice: The onCreate() method runs in the main thread.
     * Performing a long-running operation in onCreate() might block
     * the UI thread and cause a delay in loading the app. To avoid
     * this problem, run tasks such as initializing Timber and
     * scheduling WorkManager off the main thread, inside a coroutine.
     */
    private fun delayedInit() {
        applicationScope.launch {
            Timber.plant(Timber.DebugTree())
            setupRecurringWork()
            val res = VideosDatabase.instance(applicationContext).videoDao.momentOfTruth()
            Timber.e("Response List size: ${res.size}")
            res.map {
                Timber.e("$it")
            }
        }
    }
}