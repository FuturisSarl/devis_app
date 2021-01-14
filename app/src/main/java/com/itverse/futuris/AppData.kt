package com.itverse.futuris

var LIST_COMPOSANT = listOf(
    ComposantData("Matériel", "Description", R.drawable.composant_materiel),
    ComposantData("Fondation", "Description", R.drawable.composant_fondation),
    ComposantData("Elevation", "Description", R.drawable.composant_elevation),
    ComposantData("Toiture", "Description", R.drawable.composant_toiture),
    ComposantData("Finition", "Description", R.drawable.composant_finition),
    ComposantData("Electricité", "Description", R.drawable.composant_electricite),
    ComposantData("Menuiserie", "Description", R.drawable.composant_menuiserie),
    ComposantData("Plomberie", "Description", R.drawable.composant_plomberie)
)

var LIST_MATERIEL_ELEMENTS = listOf(
    ElementData(LIST_COMPOSANT[0], "Brouette", R.drawable.element_brouette),
    ElementData(LIST_COMPOSANT[0], "Equerre", R.drawable.element_equerre),
    ElementData(LIST_COMPOSANT[0], "Ficelle", R.drawable.element_ficelle),
    ElementData(LIST_COMPOSANT[0], "Fut", R.drawable.element_fut),
    ElementData(LIST_COMPOSANT[0], "Gamatte", R.drawable.element_gamatte),
    ElementData(LIST_COMPOSANT[0], "Machette", R.drawable.element_machette),
    ElementData(LIST_COMPOSANT[0], "Marteau-tenail", R.drawable.element_marteau_tenaille),
    ElementData(LIST_COMPOSANT[0], "Niveau d'eau", R.drawable.element_niveau_eau),
    ElementData(LIST_COMPOSANT[0], "Pelle", R.drawable.element_pelle),
    ElementData(LIST_COMPOSANT[0], "Pioche", R.drawable.element_pioche),
    ElementData(LIST_COMPOSANT[0], "Scie", R.drawable.element_scie),
    ElementData(LIST_COMPOSANT[0], "Tenaille", R.drawable.element_tenaille),
    ElementData(LIST_COMPOSANT[0], "Truelle", R.drawable.element_truelle, ),
    ElementData(LIST_COMPOSANT[0], "Tyrolienne", R.drawable.element_tyrolienne)
)

var LIST_PROJECTS = listOf(
    ProjectData("Projet Maison DMC"),
    ProjectData("Projet Maison Aime"),
    ProjectData("Projet Maison Joel"),
    ProjectData("Projet Maison Espe"),
)
