package br.ucsal.mobile.dogfeed.banco

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import br.ucsal.mobile.dogfeed.network.DogPhoto
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = arrayOf(DogPhoto::class), version = 1, exportSchema = false)
public abstract class UrlRoomDatabase : RoomDatabase() {

    abstract fun favsDao() : FavsDao

    private class UrlDatabaseCallback(private val scope : CoroutineScope) : RoomDatabase.Callback(){
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let {
                database -> scope.launch {
                    populateDatabase(database.favsDao())
                }
            }
        }

        suspend fun populateDatabase(favsDao: FavsDao){
            //favsDao.deleteAll()
        }
    }

    companion object {
        @Volatile
        private var INSTANCE : UrlRoomDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope):  UrlRoomDatabase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UrlRoomDatabase::class.java,
                    "url_database").addCallback(UrlDatabaseCallback(scope)).build()
                INSTANCE = instance
                instance
            }
        }
    }
}