package com.itverse.futuris.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.itverse.futuris.data.daos.ProjectDao
import com.itverse.futuris.data.entities.*
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors


@Database(
    entities = [Composant::class, Element::class, GroupedElements::class, Materiel::class, Project::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    //Defining DAOs that work with the Database
    abstract fun mProjectDao(): ProjectDao?

    companion object {
        private var INSTANCE: AppDatabase? = null
        private const val NUMBER_OF_THREADS = 4
        val databaseWriteExecutor: ExecutorService = Executors.newFixedThreadPool(NUMBER_OF_THREADS)

        @JvmStatic
        fun getDatabase(context: Context): AppDatabase? {
            if (INSTANCE == null) {
                synchronized(AppDatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            AppDatabase::class.java, "devis_app_database"
                        )
                            .fallbackToDestructiveMigration()
                            .build()
                    }
                }
            }
            return INSTANCE
        }

        /**
         * Override the onCreate method to populate the database.
         * For this sample, we clear the database every time it is created.
         */
        private val sRoomDatabaseCallback: Callback = object : Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                databaseWriteExecutor.execute {

                    // Populate the database in the background.
                    // If you want to start with more words, just add them.
                    println("DB: prepopulate DB")
                    val dao: ProjectDao? = INSTANCE?.mProjectDao()
                    //dao.deleteAll()
                    var project: Project = Project("Hello", "composant1", 1)
                    dao?.insertProject(project)
                    project = Project("World", "composant2", 2)
                    dao?.insertProject(project)
                }
            }
        }
    }
}