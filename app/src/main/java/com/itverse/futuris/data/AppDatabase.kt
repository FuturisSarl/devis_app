package com.itverse.futuris.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.itverse.futuris.data.daos.ProjectDao
import com.itverse.futuris.data.entities.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@Database(
    //entities = [Composant::class, Element::class, GroupedElements::class, Materiel::class, Project::class],
    entities = [Project::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    //Defining DAOs that work with the Database
    abstract fun projectDao(): ProjectDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): AppDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "devis_app_database"
                )
                    // Wipes and rebuilds instead of migrating if no Migration object.
                    // TODO: Consider migrations
                    .fallbackToDestructiveMigration()
                    .addCallback(AppDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                instance
            }
        }

        private class AppDatabaseCallback(
            private val scope: CoroutineScope
        ) : RoomDatabase.Callback() {
            /**
             * Override the onCreate method to populate the database.
             */
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                // TODO: If you want to keep the data through app restarts,
                // comment out the following line.
                INSTANCE?.let { database ->
                    scope.launch(Dispatchers.IO) {
                        populateDatabase(database.projectDao())
                    }
                }
            }
        }

        /**
         * Populate the database in a new coroutine.
         * If you want to start with more words, just add them.
         */
        suspend fun populateDatabase(projectDao: ProjectDao) {
            // Start the app with a clean database every time.
            // Not needed if you only populate on creation.
            projectDao.deleteAll()
            println("DB: prepopulate DB")

            var project = Project("Project A", 1)
            projectDao.insert(project)

            project = Project("Project B", 2)
            projectDao.insert(project)
        }
    }
}