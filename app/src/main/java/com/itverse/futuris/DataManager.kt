package com.itverse.futuris

import android.content.Context
import android.content.pm.PackageManager
import android.widget.Toast
import androidx.core.content.ContextCompat
import android.os.Environment
import androidx.core.app.ActivityCompat
import java.util.jar.Manifest


object DataManager {

    val projects = ArrayList<ProjectData>()
    init {
        initializeProjects()
    }

    private  fun initializeProjects() {
        projects.addAll(LIST_PROJECTS)
    }
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