package com.itverse.futuris.data

import android.content.Context
import android.util.Log
import androidx.test.platform.app.InstrumentationRegistry
import com.itverse.futuris.data.daos.*
import com.itverse.futuris.utils.createProjectFromTemplate
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.Assert.*


class AppDatabaseTest {

    lateinit var appDatabase: AppDatabase
    private val applicationScope = CoroutineScope(SupervisorJob())
    private val appContext = InstrumentationRegistry.getInstrumentation().targetContext

    @Before
    fun setUp() {
        AppDatabase.TEST_MODE = true
        appDatabase = AppDatabase.getDatabase(appContext, applicationScope)
        populateDatabase(
            appContext,
            appDatabase.projectDao(),
            appDatabase.composantDao(),
            appDatabase.groupedElementsDao(),
            appDatabase.materielDao(),
            appDatabase.elementsDao())
    }

    @After
    fun tearDown() {
    }

    @Test
    fun populateDatabase() {
        val project = appDatabase.projectDao().get("Project A")
        Log.i("projects", appDatabase.projectDao().getAllList().toString())
        assertEquals(project?.name, "Project A")
    }

    /**
     * Populate the database in a new coroutine.
     * Load test Data on dev
     * TODO: only load production data on production
     */
    private fun populateDatabase(
        context: Context,
        projectDao: ProjectDao,
        composantDao: ComposantDao,
        groupedElementsDao: GroupedElementsDao,
        materielDao: MaterielDao,
        elementsDao: ElementsDao
    ) {

        //TODO: Move template_1.json to constants: It's returning an error when importing, weird :)
        //TODO: Get project ID generated when creating the project, and use it to create composants
        createProjectFromTemplate(context, "template_1.json", "Project A", 1, projectDao,
            composantDao, groupedElementsDao, materielDao, elementsDao )

        createProjectFromTemplate(context, "template_1.json", "Project B", 2, projectDao,
            composantDao, groupedElementsDao, materielDao, elementsDao)

        createProjectFromTemplate(context, "template_1.json", "Project C", 3, projectDao,
            composantDao, groupedElementsDao, materielDao, elementsDao )

    }
}

