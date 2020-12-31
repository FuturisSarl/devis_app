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
        //TODO: Create a string array ressource for composant data and load it here
        var composant = ComposantData("Electricite", "Description", R.drawable.electricite)
        composants[composant.name] = composant

        composant = ComposantData("Elevation", "Description", R.drawable.elevation)
        composants[composant.name] = composant

        composant = ComposantData("Finition", "Description", R.drawable.finition)
        composants[composant.name] = composant

        composant = ComposantData("Fondation", "Description", R.drawable.fondation)
        composants[composant.name] = composant

        composant = ComposantData("Materiel", "Description", R.drawable.materiel)
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