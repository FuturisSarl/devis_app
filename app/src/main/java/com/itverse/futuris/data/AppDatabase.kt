package com.itverse.futuris.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.itverse.futuris.data.daos.*
import com.itverse.futuris.data.entities.*
import com.itverse.futuris.utils.PRE_POPULATE_DATABASE
import com.itverse.futuris.utils.createProjectFromTemplate
//import com.itverse.futuris.utils.PROJECT_TEMPLATE_NAME
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@Database(
    entities = [Composant::class, Element::class, GroupedElements::class, Materiel::class, Project::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    //Defining DAOs that work with the Database
    abstract fun projectDao(): ProjectDao
    abstract fun composantDao(): ComposantDao
    abstract fun elementsDao(): ElementsDao
    abstract fun groupedElementsDao(): GroupedElementsDao
    abstract fun materielDao(): MaterielDao

    companion object {

        var TEST_MODE = false

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): AppDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                var instance : AppDatabase

                if (TEST_MODE){
                instance = Room.inMemoryDatabaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java
                )
                    // Wipes and rebuilds instead of migrating if no Migration object.
                    // TODO: Consider migrations
                    .fallbackToDestructiveMigration()
                    .addCallback(AppDatabaseCallback(scope, context))
                    .build()
                INSTANCE = instance }
                else{
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "devis_app_database"
                    )
                        // Wipes and rebuilds instead of migrating if no Migration object.
                        // TODO: Consider migrations
                        .fallbackToDestructiveMigration()
                        .addCallback(AppDatabaseCallback(scope, context))
                        .build()
                    INSTANCE = instance
                }
                instance
            }
        }

        private class AppDatabaseCallback(
            private val scope: CoroutineScope,
            private val context: Context
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
                        populateDatabase(
                            context,
                            database.projectDao(),
                            database.composantDao(),
                            database.groupedElementsDao(),
                            database.materielDao(),
                            database.elementsDao()
                        )

                    }
                }
            }
        }

        /**
         * Populate the database in a new coroutine.
         * Load test Data on dev
         * TODO: only load production data on production
         */

        suspend fun populateDatabase(
            context: Context,
            projectDao: ProjectDao,
            composantDao: ComposantDao,
            groupedElementsDao: GroupedElementsDao,
            materielDao: MaterielDao,
            elementsDao: ElementsDao
        ) {
            // Start the app with a clean database every time.
            // Not needed if you only populate on creation.

            if (!PRE_POPULATE_DATABASE)
                return

            projectDao.deleteAll()

            //TODO: Move template_1.json to constants: It's returning an error when importing, weird :)
            //TODO: Get project ID generated when creating the project, and use it to create composants
            createProjectFromTemplate(context, "template_1.json", "Project A", 1,
                projectDao, composantDao, groupedElementsDao, materielDao, elementsDao)

            createProjectFromTemplate(context, "template_1.json", "Project B", 2,
                projectDao, composantDao, groupedElementsDao, materielDao, elementsDao)

            createProjectFromTemplate(context, "template_1.json", "Project C", 3,
                projectDao, composantDao, groupedElementsDao, materielDao,elementsDao )



        }
    }
}
