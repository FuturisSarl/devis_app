package com.itverse.futuris

var LIST_MATERIEL_ELEMENTS = arrayListOf(
    MaterielData("Brouette", R.drawable.element_brouette),
    MaterielData("Equerre", R.drawable.element_equerre),
    MaterielData( "Ficelle", R.drawable.element_ficelle),
    MaterielData( "Fut", R.drawable.element_fut),
    MaterielData( "Gamatte", R.drawable.element_gamatte),
    MaterielData( "Machette", R.drawable.element_machette),
    MaterielData( "Marteau-tenail", R.drawable.element_marteau_tenaille),
    MaterielData( "Niveau d'eau", R.drawable.element_niveau_eau),
    MaterielData( "Pelle", R.drawable.element_pelle),
    MaterielData( "Pioche", R.drawable.element_pioche),
    MaterielData( "Scie", R.drawable.element_scie),
    MaterielData( "Tenaille", R.drawable.element_tenaille),
    MaterielData( "Truelle", R.drawable.element_truelle, ),
    MaterielData( "Tyrolienne", R.drawable.element_tyrolienne)
)


var LIST_GROUPED_ELEMENT_DATA_FONDATION = arrayListOf(
    GroupedElementsData(
        "Implantation",
        arrayListOf(
            ElementsDetailData("Chaise X"),
            ElementsDetailData("Chaise Y"),
        ),
    ),
    GroupedElementsData(
        "Beton de propreté",
        arrayListOf(
            ElementsDetailData("Volume total du béton"),
        ),
    ),
    GroupedElementsData(
        "Socle en BA",
        arrayListOf(
            ElementsDetailData("Nombre de socles X"),
            ElementsDetailData("Section du socle"),
        ),
    ),

)

var LIST_COMPOSANT = arrayListOf(
    ComposantData("Matériel", "Description", R.drawable.composant_materiel, null, materiels =LIST_MATERIEL_ELEMENTS),
    ComposantData("Fondation", "Description", R.drawable.composant_fondation,LIST_GROUPED_ELEMENT_DATA_FONDATION),
    ComposantData("Elevation", "Description", R.drawable.composant_elevation, LIST_GROUPED_ELEMENT_DATA_FONDATION),
    ComposantData("Toiture", "Description", R.drawable.composant_toiture, LIST_GROUPED_ELEMENT_DATA_FONDATION),
    ComposantData("Finition", "Description", R.drawable.composant_finition, LIST_GROUPED_ELEMENT_DATA_FONDATION),
    ComposantData("Electricité", "Description", R.drawable.composant_electricite, LIST_GROUPED_ELEMENT_DATA_FONDATION),
    ComposantData("Menuiserie", "Description", R.drawable.composant_menuiserie, LIST_GROUPED_ELEMENT_DATA_FONDATION),
    ComposantData("Plomberie", "Description", R.drawable.composant_plomberie, LIST_GROUPED_ELEMENT_DATA_FONDATION)
)


var LIST_PROJECTS = listOf(
    ProjectData("Projet Maison DMC", LIST_COMPOSANT ),
    ProjectData("Projet Maison Aime", LIST_COMPOSANT),
    ProjectData("Projet Maison Joel", LIST_COMPOSANT),
    ProjectData("Projet Maison Espe", LIST_COMPOSANT),
)
