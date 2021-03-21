package com.itverse.futuris

import android.content.Context
import android.content.pm.PackageManager
import android.widget.Toast
import androidx.core.content.ContextCompat
import android.os.Environment
import androidx.core.app.ActivityCompat
import com.itverse.futuris.utils.createProjectFromTemplate
import java.util.jar.Manifest


object DataManager {
    var projects = ArrayList<ProjectData>()
}

private fun isExternalStorageReadOnly(): Boolean {
    val extStorageState = Environment.getExternalStorageState()
    return Environment.MEDIA_MOUNTED_READ_ONLY == extStorageState
}

private fun isExternalStorageAvailable(): Boolean {
    val extStorageState = Environment.getExternalStorageState()
    return Environment.MEDIA_MOUNTED == extStorageState
}

public fun generateExcelFile(context:Context, projectID: Int): Boolean {
    println("Generating an excel file for project at "  + "/SimpleBudget.xlsx")

    if (!isExternalStorageAvailable() || isExternalStorageReadOnly()) {
        println("Storage not available or read only");
        return false;
    }
    else{
        println("All good")
    }


    Toast.makeText(context, Environment.DIRECTORY_DOWNLOADS + "/SimpleBudget.xlsx", Toast.LENGTH_LONG).show()
    return true;
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