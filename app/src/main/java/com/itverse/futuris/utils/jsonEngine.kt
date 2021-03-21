package com.itverse.futuris.utils
import com.google.gson.Gson

import java.util.ArrayList
import com.google.gson.reflect.TypeToken
import com.itverse.futuris.ProjectData
import java.io.File

import android.content.Context
import java.io.IOException

fun getJsonDataFromAsset(context: Context, fileName: String): String? {
    val jsonString: String
    try {
        jsonString = context.assets.open(fileName).bufferedReader().use { it.readText()}
    } catch (ioException: IOException) {
        ioException.printStackTrace()
        return null
    }
    println(jsonString)
    return jsonString
}

fun getJsonDataFromAssetNoContext(filename: String): String? {
    val jsonString: String
    try {
        jsonString = File(filename).bufferedReader().use { it.readText()}

    } catch (ioException: IOException) {
        ioException.printStackTrace()
        println( ioException)
        return null
    }
    return jsonString
}


fun serializer(model: ArrayList<ProjectData>) {
    val gson = Gson()
    val jsonString = gson.toJson(model)
    println(jsonString)
}

fun deserializer(context: Context) {
    val inputString = getJsonDataFromAsset(context, "template_1.json")
    val projectModel = object : TypeToken<ProjectData>() {}.type
    val gson = Gson()
    val outputList = gson.fromJson<ProjectData>(inputString, projectModel)
}

fun createProjectFromTemplate(context: Context, template_name: String): ProjectData? {
    val inputString = getJsonDataFromAsset(context, template_name)
    val projectModel = object : TypeToken<ProjectData>() {}.type
    val gson = Gson()
    val projectJSON = gson.fromJson<ProjectData>(inputString, projectModel)
    println("Serialized : ${gson.toJson(projectJSON)}")

    return projectJSON
}