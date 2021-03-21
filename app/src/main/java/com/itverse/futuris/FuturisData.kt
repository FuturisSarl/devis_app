package com.itverse.futuris

data class ProjectData(
    var name: String,
    var composants: ArrayList<Composant>,
)
data class Composant(
    var name: String,
    var description: String,
    var imageResource: Int,
    var groupedElements: ArrayList<GroupedElements>?,
    var materiels: ArrayList<Materiel>? = null
) {}

data class Materiel (
    var name: String,
    var imageResource: Int,
    var number: Int = 0){}

data class GroupedElements(
    val title: String,
    var details: ArrayList<ElementsDetail>,
){}

data class ElementsDetail(
    var name: String,
    var unit: String? = null, //Won't display unit if null
    var value: Int? = null, //TODO: Handle Double? Use Any as type on this declaration? [null for value not set]
){}