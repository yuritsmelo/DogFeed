package br.ucsal.mobile.dogfeed.banco

import androidx.annotation.WorkerThread
import br.ucsal.mobile.dogfeed.network.DogPhoto
import kotlinx.coroutines.flow.Flow 

class UrlRepository(private val favsDao: FavsDao) {

    val allUrls: Flow<List<DogPhoto>> = favsDao.getAllUrls()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(dogPhoto: DogPhoto){
        favsDao.insert(dogPhoto)
    }
}
