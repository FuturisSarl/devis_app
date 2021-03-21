package com.itverse.futuris.worksheetTest
import com.google.gson.Gson

import java.util.ArrayList
import com.google.gson.reflect.TypeToken


class Item     // getters and setters
    (val id: Int, val name: String)

class MyModel(
    val id: Int,
    val name: String,
    val items: List<Item>
    )


fun serializer() {

    val item1 = Item(1, "item1")
    val item2 = Item(2, "item2")
    val items = ArrayList<Item>()
    items.add(item1)
    items.add(item2)

    val model = MyModel(1, "model", items)
    val gson = Gson()
    val jsonString = gson.toJson(model)
    println(jsonString)
}

fun deserializer() {
    val inputString = "{\"id\":1,\"name\":\"model\",\"items\":[{\"id\":1,\"name\":\"item1\"},{\"id\":2,\"name\":\"item2\"}]}"

    val listOfMyClassObject = object : TypeToken<MyModel>() {}.type
    val gson = Gson()
    val outputList = gson.fromJson<MyModel>(inputString, listOfMyClassObject)
    println(outputList)
    println(inputString)
    println(gson.toJson(outputList))

}

//serializer()
//deserializer()
//givenJsonString_whenDeserializing_thenReturnListOfMyClass()