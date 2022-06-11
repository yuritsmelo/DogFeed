package br.ucsal.mobile.dogfeed.banco

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.ucsal.mobile.dogfeed.network.DogPhoto
import kotlinx.coroutines.flow.Flow

@Dao
interface FavsDao {
    @Query("SELECT * FROM url_table")
    fun getAllUrls(): Flow<List<DogPhoto>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(dogPhoto: DogPhoto)

    @Query("DELETE FROM url_table")
    suspend fun deleteAll()
}