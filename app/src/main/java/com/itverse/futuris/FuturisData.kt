package com.itverse.futuris

class ProjectData(
    var name: String,
    //var composants: List<ComposantData>,
)
class ComposantData (
    var name: String,
    var description: String,
    var imageResource: Int) {}

class ElementData (
    val composant: ComposantData,
    var name: String,
    var imageResource: Int,
    var number: Int = 0){}