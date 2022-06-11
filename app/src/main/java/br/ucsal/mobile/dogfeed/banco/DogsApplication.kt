package br.ucsal.mobile.dogfeed.banco

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class DogsApplication : Application() {
    val applicationScope = CoroutineScope(SupervisorJob())

    val database by lazy { UrlRoomDatabase.getDatabase(this, applicationScope) }
    val repository by lazy { UrlRepository(database.favsDao())}
}