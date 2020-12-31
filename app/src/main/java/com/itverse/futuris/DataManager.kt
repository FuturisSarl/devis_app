package com.itverse.futuris

import androidx.core.graphics.drawable.toDrawable

object DataManager {

    val composants = LinkedHashMap<String, ComposantData>()
    val elements = ArrayList<ElementData>()

    init {
        initializeComposants()
        initializeElements()
    }

    private fun initializeComposants() {

        LIST_COMPOSANT.forEach{
            composants[it.name] = it
        }
    }

    private fun initializeElements() {
        elements.addAll(LIST_MATERIEL_ELEMENTS)
    }
}