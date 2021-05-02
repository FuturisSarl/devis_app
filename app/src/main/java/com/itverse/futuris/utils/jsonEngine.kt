package com.itverse.futuris.utils
import java.io.File

import android.content.Context
import com.google.gson.Gson
import com.itverse.futuris.data.daos.ComposantDao
import com.itverse.futuris.data.daos.GroupedElementsDao
import com.itverse.futuris.data.daos.MaterielDao
import com.itverse.futuris.data.daos.ProjectDao
import com.itverse.futuris.data.entities.Composant
import com.itverse.futuris.data.entities.GroupedElements
import com.itverse.futuris.data.entities.Project
import java.io.IOException

//TODO: Create similar function to create multiple projects. Use case: create project from an online backup
suspend fun createProjectFromTemplate(context: Context,
                                      template_name: String,
                                      projectName: String,
                                      projectId: Int,
                                      projectDao: ProjectDao,
                                      composantDao: ComposantDao,
                                      groupedElementsDao: GroupedElementsDao,
                                      materielDao: MaterielDao)
{

    val inputString = getJsonDataFromAsset(context, template_name)

    val gson = Gson()
    val map = gson.fromJson(inputString, MutableMap::class.java)
    var project = Project(projectName)

    //TODO: create entries for GroupedElements and Materiel. Would need the id of composant created to set it on the composant foreign key
    val composants: List<Composant> =
        (map["composants"]!! as ArrayList<MutableMap<String, String>>).map { Composant(projectId, it["name"]!!, it["description"]!!, it["imageResource"]!!) }

    projectDao.insertProjectWithComposants(project, composants)
}

fun getJsonDataFromAsset(context: Context, fileName: String): String? {
    val jsonString: String
    try {
        jsonString = context.assets.open(fileName).bufferedReader().use { it.readText()}
    } catch (ioException: IOException) {
        ioException.printStackTrace()
        return null
    }
    return jsonString
}
