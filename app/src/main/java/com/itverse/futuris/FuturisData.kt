package com.itverse.futuris

class ProjectData(
    var name: String,
    var composants: ArrayList<Composant>,
)
class Composant(
    var name: String,
    var description: String,
    var imageResource: Int,
    var elements: ArrayList<GroupedElements>?,
    var materiels: ArrayList<Materiel>? = null
) {}

class Materiel (
    var name: String,
    var imageResource: Int,
    var number: Int = 0){}

class GroupedElements(
    val title: String,
    var details: ArrayList<ElementsDetail>,
){}

class ElementsDetail(
    var name: String,
    var inputUnit: String? = null, //Won't display unit if null
    var inputValue: Int? = null, //TODO: Handle Double? Use Any as type on this declaration? [null for value not set]
){}