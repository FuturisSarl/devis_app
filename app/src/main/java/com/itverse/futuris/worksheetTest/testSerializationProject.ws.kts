package com.itverse.futuris.worksheetTest
import com.google.gson.Gson

import java.util.ArrayList
import com.google.gson.reflect.TypeToken
import com.itverse.futuris.ProjectData
import java.io.File
import java.io.IOException


class Item     // getters and setters
    (val id: Int, val name: String)

class MyModel(
    val id: Int,
    val name: String,
    val items: List<Item>
)

fun getJsonDataFromAsset(filename: String): String? {
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

fun deserializer() {

    val inputString = getJsonDataFromAsset("./test1.json")
    val projectModel = object : TypeToken<ProjectData>() {}.type
    val gson = Gson()
    val outputList = gson.fromJson<ProjectData>(inputString, projectModel)
    println(outputList)
    println(inputString)
    println(gson.toJson(outputList))

}

//serializer(LIST_PROJECTS[0])
deserializer()