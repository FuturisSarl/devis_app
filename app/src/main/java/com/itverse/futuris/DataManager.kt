package com.itverse.futuris

import android.content.Context
import com.itverse.futuris.utils.createProjectFromTemplate

object DataManager {
    var projects = ArrayList<ProjectData>()
}

fun loadProjects(context: Context){
    val project1 = createProjectFromTemplate(context, PROJECT_TEMPLATE_NAME)
    project1?.name = "Projet 1"
    val project2 = createProjectFromTemplate(context, PROJECT_TEMPLATE_NAME)
    project1?.name = "Projet 2"
    val project3 = createProjectFromTemplate(context, PROJECT_TEMPLATE_NAME)
    project3?.name = "Projet 3"

    DataManager.projects.add(project1!!)
    DataManager.projects.add(project2!!)
    DataManager.projects.add(project3!!)

}