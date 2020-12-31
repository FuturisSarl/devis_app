package com.itverse.futuris

var LIST_COMPOSANT = listOf(
    ComposantData("Matériel", "Description", R.drawable.materiel),
    ComposantData("Fondation", "Description", R.drawable.fondation),
    ComposantData("Elevation", "Description", R.drawable.elevation),
    ComposantData("Toiture", "Description", R.drawable.toiture),
    ComposantData("Finition", "Description", R.drawable.finition),
    ComposantData("Electricité", "Description", R.drawable.electricite),
    ComposantData("Menuiserie", "Description", R.drawable.menuiserie),
    ComposantData("Plomberie", "Description", R.drawable.plomberie)
)

var LIST_MATERIEL_ELEMENTS = listOf(
    ElementData(LIST_COMPOSANT[0], "Brouette", R.drawable.brouette, 1),
    ElementData(LIST_COMPOSANT[0], "Ficelle", R.drawable.ficelle, 1),
    ElementData(LIST_COMPOSANT[0], "Machette", R.drawable.machette, 1),
    ElementData(LIST_COMPOSANT[0], "Gamatte", R.drawable.gamatte, 1),
    ElementData(LIST_COMPOSANT[0], "Tyrolienne", R.drawable.tyrolienne, 1),
    ElementData(LIST_COMPOSANT[0], "Tenaille", R.drawable.tenaille, 1),
    ElementData(LIST_COMPOSANT[0], "Truelle", R.drawable.truelle, 1)
)