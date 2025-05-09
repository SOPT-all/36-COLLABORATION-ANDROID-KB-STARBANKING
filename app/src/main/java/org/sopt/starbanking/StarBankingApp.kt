package org.sopt.starbanking

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import timber.log.Timber
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class StarBankingApp : Application() {
    override fun onCreate() {
        super.onCreate()
        setTimber()
        setLightMode()
    }

    private fun setTimber() {
        Timber.plant(Timber.DebugTree())
    }

    private fun setLightMode() {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }
}
