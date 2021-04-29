package com.itverse.futuris.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.itverse.futuris.data.daos.*
import com.itverse.futuris.data.entities.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@Database(
    entities = [Composant::class, Element::class, GroupedElements::class, Materiel::class, Project::class],
    version = 2,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    //Defining DAOs that work with the Database
    abstract fun projectDao(): ProjectDao
    abstract fun composantDao(): ComposantDao
    /*abstract fun elementsDao(): ElementsDao
    abstract fun groupedElementsDao(): GroupedElementsDao
    abstract fun materielDao(): MaterielDao*/

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
                        populateDatabase(database.projectDao(), database.composantDao())
                    }
                }
            }
        }

        /**
         * Populate the database in a new coroutine.
         * Load test Data on dev
         * TODO: only load production data on production
         */
        suspend fun populateDatabase(projectDao: ProjectDao, composantDao: ComposantDao) {
            // Start the app with a clean database every time.
            // Not needed if you only populate on creation.
            projectDao.deleteAll()
            println("DB: prepopulate DB")

            var project = Project("Project A", 1)
            projectDao.insert(project)

            project = Project("Project B", 2)
            projectDao.insert(project)

            var composant = Composant(1, 1, "Composant 1", "Composant Description", "composant_materiel")
            composantDao.insert(composant)

            composant = Composant(2, 1, "Composant 2", "Composant Description", "composant_fondation")
            composantDao.insert(composant)

            composant = Composant(3, 2, "Composant 3", "Composant Description", "composant_materiel")
            composantDao.insert(composant)

            composant = Composant(4, 2, "Composant 4", "Composant Description", "composant_fondation")
            composantDao.insert(composant)
        }
    }
}