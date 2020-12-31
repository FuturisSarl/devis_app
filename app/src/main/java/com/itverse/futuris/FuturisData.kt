package com.itverse.futuris

import android.graphics.drawable.Drawable

class ComposantData (var name: String, var description: String, var imageResource: Int) {}

class ElementData (
    val composant: ComposantData,
    var name: String,
    var imageResource: Int,
    var number: Int){

}