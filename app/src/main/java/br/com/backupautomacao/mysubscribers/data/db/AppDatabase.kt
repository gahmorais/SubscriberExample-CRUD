package br.com.backupautomacao.mysubscribers.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.backupautomacao.mysubscribers.data.db.dao.SubscriberDao
import br.com.backupautomacao.mysubscribers.data.db.entity.SubscriberEntity

@Database(entities = [SubscriberEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
  abstract val subscriberDao: SubscriberDao

  companion object {
    @Volatile
    private var INSTANCE: AppDatabase? = null

    fun getInstance(context: Context): AppDatabase {
      return INSTANCE ?: synchronized(this) {
        val instance = Room.databaseBuilder(
          context.applicationContext,
          AppDatabase::class.java,
          "app_database"
        ).build()
        INSTANCE = instance
        instance
      }
    }
  }
}
