package com.itverse.futuris.utils

import android.content.Context
import com.google.gson.Gson
import com.itverse.futuris.data.daos.*
import com.itverse.futuris.data.entities.*
import com.itverse.futuris.mViewModels.*
import java.io.IOException

//TODO: Create similar function to create multiple projects. Use case: create project from an online backup
suspend fun createProjectFromTemplate(
    context: Context,
    projectName: String,
    projectId: Long,
    projectDao: ProjectDao,
    composantDao: ComposantDao,
    groupedElementsDao: GroupedElementsDao,
    materielDao: MaterielDao,
    elementsDao: ElementsDao
)
{

    val inputString = getJsonDataFromAsset(context, PROJECT_TEMPLATE_NAME)

    val gson = Gson()
    val map = gson.fromJson(inputString, MutableMap::class.java)
    val project = Project(projectName)
    projectDao.insert(project)

    var groupedElementId: Long
    var composant: Composant
    var composantId: Long

    //TODO: Make this imbrication a recursive call, to be more concise and easy to read
    (map["composants"]!! as ArrayList<MutableMap<String, String>>).forEach {

        composant = Composant(projectId, it["name"]!!,  it["description"]!!, it["imageResource"]!!)
        composantId = composantDao.insert(composant)
        if (it["materials"] != null){
            (it["materials"]!! as ArrayList<MutableMap<String,String>>).forEach { materiel ->
                materielDao.insert(Materiel(composantId, materiel["name"]!!,materiel["imageResource"]!!))
            }
        }
        else if(it["groupedElements"] != null) {
            (it["groupedElements"]!! as ArrayList<MutableMap<String,String>>).forEach { groupedElement ->
                groupedElementId = groupedElementsDao.insert(GroupedElements(composantId, groupedElement["name"]!!))
                if (groupedElement["elements"] != null){
                    (groupedElement["elements"]!! as ArrayList<MutableMap<String,String>>).forEach{ element ->
                        elementsDao.insert(Element(groupedElementId, element["name"]!!,element["unit"]!!, 0))
                    }
                }
            }
        }
    }

}



suspend fun createProjectFromTemplate_vm(
    context: Context,
    projectName: String,
    projectViewModel: ProjectViewModel,
    composantViewModel: ComposantViewModel,
    groupedElementsViewModel: GroupedElementsViewModel,
    materielViewModel: MaterielViewModel,
    elementViewModel: ElementViewModel
): Long

{

    val inputString = getJsonDataFromAsset(context, PROJECT_TEMPLATE_NAME)

    val gson = Gson()
    val map = gson.fromJson(inputString, MutableMap::class.java)
    val project = Project(projectName)
    val projectId = projectViewModel.insert(project)

    var groupedElementId: Long
    var composant: Composant
    var composantId: Long

    //TODO: Make this imbrication a recursive call, to be more concise and easy to read
    (map["composants"]!! as ArrayList<MutableMap<String, String>>).forEach {

        composant = Composant(projectId, it["name"]!!,  it["description"]!!, it["imageResource"]!!)
        composantId = composantViewModel.insert(composant)
        if (it["materials"] != null){
            (it["materials"]!! as ArrayList<MutableMap<String,String>>).forEach { materiel ->
                materielViewModel.insert(Materiel(composantId, materiel["name"]!!,materiel["imageResource"]!!))
            }
        }
        else if(it["groupedElements"] != null) {
            (it["groupedElements"]!! as ArrayList<MutableMap<String,String>>).forEach { groupedElement ->
                groupedElementId = groupedElementsViewModel.insert(GroupedElements(composantId, groupedElement["name"]!!))
                if (groupedElement["elements"] != null){
                    (groupedElement["elements"]!! as ArrayList<MutableMap<String,String>>).forEach{ element ->
                        elementViewModel.insert(Element(groupedElementId, element["name"]!!,element["unit"]!!, 0))
                    }
                }
            }
        }
    }
    return projectId
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
