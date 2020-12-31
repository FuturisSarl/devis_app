package com.itverse.futuris

import androidx.core.graphics.drawable.toDrawable

object DataManager {

    val composants = HashMap<String, ComposantData>()
    val elements = ArrayList<ElementData>()

    init {
        initializeComposants()
        initializeElements()
    }

    private fun initializeComposants() {
        //TODO: Create a string array ressource for composant data and load it here
        var composant = ComposantData("Materiel", "Description", R.drawable.electricite.toDrawable())
        composants[composant.name] = composant
    }

    private fun initializeElements() {
        var composant = composants["Materiel"]!!
        var element = ElementData(
            composant,
            "Test1",
            R.drawable.materiel_item_1,
            1)
        elements.add(element)

        element = ElementData(
            composant,
            "Test1",
            R.drawable.materiel_item_2,
            1)

        elements.add(element)

        element = ElementData(
            composant,
            "Test1",
            R.drawable.materiel_item_3,
            1)
        elements.add(element)

        element = ElementData(
            composant,
            "Test1",
            R.drawable.materiel_item_4,
            1)

        elements.add(element)

    }
}