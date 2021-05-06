package com.itverse.futuris.utils

import android.content.Context
import com.google.gson.Gson
import com.itverse.futuris.data.daos.*
import com.itverse.futuris.data.entities.*
import java.io.IOException

//TODO: Create similar function to create multiple projects. Use case: create project from an online backup
fun createProjectFromTemplate(
    context: Context,
    template_name: String,
    projectName: String,
    projectId: Long,
    projectDao: ProjectDao,
    composantDao: ComposantDao,
    groupedElementsDao: GroupedElementsDao,
    materielDao: MaterielDao,
    elementsDao: ElementsDao
)
{

    val inputString = getJsonDataFromAsset(context, template_name)

    val gson = Gson()
    val map = gson.fromJson(inputString, MutableMap::class.java)
    var project = Project(projectName)
    projectDao.insert(project)

    var materiel: Materiel
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
                        elementsDao.insert(Element(groupedElementId, element["name"]!!,element["unit"]!!))
                    }
                }
            }
        }
    }

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
