package com.itverse.futuris

object DataManager {

    val projects = ArrayList<ProjectData>()

    init {
        initializeProjects()
    }

    private  fun initializeProjects() {
        projects.addAll(LIST_PROJECTS)
    }
}