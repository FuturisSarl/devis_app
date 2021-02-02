package com.itverse.futuris

class ProjectData(
    var name: String,
    var composants: ArrayList<ComposantData>,
)
class ComposantData(
    var name: String,
    var description: String,
    var imageResource: Int,
    var elements: ArrayList<GroupedElementsData>?,
    var materiels: ArrayList<MaterielData>? = null,
) {}

class MaterielData (
    var name: String,
    var imageResource: Int,
    var number: Int = 0){}

class GroupedElementsData(
    val title: String,
    var details: ArrayList<ElementsDetailData>,
){}

class ElementsDetailData(
    var name: String,
    var inputUnit: String? = null, //Won't display unit if null
    var inputValue: Int? = null, //TODO: Handle Double? Use Any as type on this declaration? [null for value not set]
){}