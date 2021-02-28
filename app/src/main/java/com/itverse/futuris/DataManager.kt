package com.itverse.futuris

object DataManager {

    val composants = LinkedHashMap<String, ComposantData>()
    val elements = ArrayList<ElementData>()
    val projects = ArrayList<ProjectData>()
    init {
        initializeProjects()
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

    private  fun initializeProjects() {
        projects.addAll(LIST_PROJECTS)
    }
}