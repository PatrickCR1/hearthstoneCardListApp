package com.example.hearthstonelist

import android.app.Application
import com.example.hearthstonelist.di.modules.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class HearthstoneApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@HearthstoneApplication)
            modules(
                listOf(
                    hearthstoneWebClientModules,
                    hearthstoneRepositoryModules,
                    hearthstoneViewModelModules,
                    hearthstoneAdapterModules
                )
            )
        }
    }
}
