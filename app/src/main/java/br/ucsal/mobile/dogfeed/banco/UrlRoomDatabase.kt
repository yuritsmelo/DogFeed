package br.ucsal.mobile.dogfeed.banco

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.ucsal.mobile.dogfeed.network.DogPhoto
import java.security.AccessControlContext

@Database(entities = arrayOf(DogPhoto::class), version = 1, exportSchema = false)
public abstract class UrlRoomDatabase : RoomDatabase() {

    abstract fun favsDao() : FavsDao

    companion object {
        @Volatile
        private var INSTANCE : UrlRoomDatabase? = null

        fun getDatabase(context: Context):  UrlRoomDatabase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UrlRoomDatabase::class.java,
                    "url_database").build()
                INSTANCE = instance
                instance
            }
        }
    }
}