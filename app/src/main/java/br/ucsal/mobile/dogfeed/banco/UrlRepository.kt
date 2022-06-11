package br.ucsal.mobile.dogfeed.banco

import androidx.annotation.WorkerThread
import br.ucsal.mobile.dogfeed.network.DogPhoto
import kotlinx.coroutines.flow.Flow

class UrlRepository(private val urlDao: FavsDao) {

    val allUrls: Flow<List<DogPhoto>> = urlDao.getAllUrls()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(dogPhoto: DogPhoto){
        urlDao.insert(dogPhoto)
    }
}