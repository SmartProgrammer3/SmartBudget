package com.example.smartbudget

import android.app.Application
import com.example.smartbudget.Screens.AppDatabase

class MyApp : Application() {
    val database: AppDatabase by lazy { AppDatabase.getDatabase(this) }
}
