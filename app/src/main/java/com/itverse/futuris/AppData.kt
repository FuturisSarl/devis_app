package com.itverse.futuris

/**
 * TODO: Load these data from a JSON file. These JSON file will be portable and will serve as a template of a given construction material requirements
 */
var LIST_MATERIEL = arrayListOf(
    Materiel("Brouette", R.drawable.element_brouette),
    Materiel("Equerre", R.drawable.element_equerre),
    Materiel( "Ficelle", R.drawable.element_ficelle),
    Materiel( "Fut", R.drawable.element_fut),
    Materiel( "Gamatte", R.drawable.element_gamatte),
    Materiel( "Machette", R.drawable.element_machette),
    Materiel( "Marteau-tenail", R.drawable.element_marteau_tenaille),
    Materiel( "Niveau d'eau", R.drawable.element_niveau_eau),
    Materiel( "Pelle", R.drawable.element_pelle),
    Materiel( "Pioche", R.drawable.element_pioche),
    Materiel( "Scie", R.drawable.element_scie),
    Materiel( "Tenaille", R.drawable.element_tenaille),
    Materiel( "Truelle", R.drawable.element_truelle, ),
    Materiel( "Tyrolienne", R.drawable.element_tyrolienne)
)


var LIST_GROUPED_ELEMENT_DATA_FONDATION = arrayListOf(
    GroupedElements(
        "Implantation",
        arrayListOf(
            ElementsDetail("Chaise X"),
            ElementsDetail("Chaise Y"),
        ),
    ),
    GroupedElements(
        "Beton de propreté",
        arrayListOf(
            ElementsDetail("Volume total du béton"),
        ),
    ),
    GroupedElements(
        "Socle en BA",
        arrayListOf(
            ElementsDetail("Nombre de socles"),
            ElementsDetail("Section du socle"),
            ElementsDetail("Perimètre de la section"),
            ElementsDetail("Hauteur du socle"),
            ElementsDetail("Nombre d'étrier/socles"),
            ElementsDetail("Nombre de barre/socles"),
            ElementsDetail("Volume total du béton"),

        ),
    ),
    GroupedElements(
        "Longrine en BQ",
        arrayListOf(
            ElementsDetail("Mettre linéaire de la longrine"),
            ElementsDetail("Section de la longrine"),
            ElementsDetail("Périmètre de la section"),
            ElementsDetail("Nombre d'étrier/poutre"),
            ElementsDetail("Nombre de barre/longrine"),
            ElementsDetail("Volume total du béton"),
        ),
    ),
    GroupedElements(
        title = "Maconnerie en moellon",
        arrayListOf(
            ElementsDetail("Mettre linéaire de la fondation"),
        ),
    ),
)

var LIST_GROUPED_ELEMENT_DATA_ELEVATION = arrayListOf(
        GroupedElements(
            "Collones en B.A",
            arrayListOf(
                ElementsDetail("Nombre de collones"),
                ElementsDetail("Perimètre de la section"),
                ElementsDetail("Hauteur de la colonne(moyenne)"),
                ElementsDetail("Nombre de barre/colonnes"),
            ),
        ),
        GroupedElements(
            "Poutre en B.A",
            arrayListOf(
                ElementsDetail("Mettre linéaire de la poutre"),
                ElementsDetail("Section de la poutre"),
                ElementsDetail("Perimètre de la section"),
                ElementsDetail("Nombre d'étrier/poutre"),
                ElementsDetail("Nombre de barre/poutre"),
                ElementsDetail("Volume total du béton"),
            ),
        ),
        GroupedElements(
            "Maconnerie",
            arrayListOf(
                ElementsDetail("Mur"),
            ),
        ),
)

var LIST_GROUPED_ELEMENT_DATA_TOITURE= arrayListOf(
        GroupedElements(
            "Couverture",
            arrayListOf(
                ElementsDetail("Surface à couvrir"),
            ),
        ),
)

var LIST_GROUPED_ELEMENT_DATA_FINITION= arrayListOf(
        GroupedElements(
            "Carrelage",
            arrayListOf(
                ElementsDetail("Carreaux (60*60)"),
                ElementsDetail("Carreaux anti-dépadant(30cm*30cm)"),
                ElementsDetail("Faiences(30cm*15cm)"),
            ),
        ),
        GroupedElements(
            "Peinture",
            arrayListOf(

            ),
        ),
        GroupedElements(
            "Plafond",
            arrayListOf(
                ElementsDetail("Faux plafond et accessoires"),
            ),
        ),
        GroupedElements(
            "Enduit",
            arrayListOf(

            ),
        ),
)

var LIST_GROUPED_ELEMENT_DATA_ELECTRICITE= arrayListOf(
        GroupedElements(
            "Carrelage",
            arrayListOf(
                ElementsDetail("Lustre salon"),
                ElementsDetail("Lustre salle à manger"),
                ElementsDetail("Plafonnier encastré pour cuisine"),
                ElementsDetail("Spots encastrés"),
                ElementsDetail("Applique murale"),
                ElementsDetail("Plafonnier encastré pour salle d'eau"),
                ElementsDetail("Socket(generated)"),
                ElementsDetail("Interrupteur encastrée simple direction"),
                ElementsDetail("Interrupteur encastrée double direction"),
                ElementsDetail("Interrupteur bipolaire encastrée double direction"),
                ElementsDetail("Prises type poste de travail"),
                ElementsDetail("Prise encastrée avec terre"),
                ElementsDetail("Prises encastrée hermetique avec terre"),
                ElementsDetail("Prises encastrée télé"),
                ElementsDetail("Réseau d'alimentation des climatiseurs "),
                ElementsDetail("Réseau d'alimentation des prises"),
                ElementsDetail("Réseau d'alimentation des points limineux"),
                ElementsDetail("Tableau divisionnaire et accessoire"),
                ElementsDetail("Carreaux anti-dépadant(30cm*30cm)"),
        ),
    ),
)
var LIST_GROUPED_ELEMENT_DATA_MENUISERIE= arrayListOf(
        GroupedElements(
            "Type portes",
            arrayListOf(
                ElementsDetail("80cm*250cm-Bois"),
                ElementsDetail("Porte (90cm*250cm-Bois)"),
                ElementsDetail("Porte d'entrée principale (300cm*250cm)-Métal"),
            ),
        ),
        GroupedElements(
            "Type fenetre",
            arrayListOf(

                ElementsDetail("Fenêtre-type1(150cm*200cm-Métal)"),
                ElementsDetail("Fenêtre-type2(200cm*200cm-Métal)"),
                ElementsDetail("Fenêtre-salle à manger(1500cm*200cm)-Métal"),

            ),
        ),
        GroupedElements(
            "Type impostes",
            arrayListOf(
                ElementsDetail("Imposte(60cm*60cm)"),
            ),
        ),
)

var LIST_GROUPED_ELEMENT_DATA_PLOMBERIE= arrayListOf(
    GroupedElements(
        "Materiaux",
        arrayListOf(
            ElementsDetail("Cuve"),
            ElementsDetail("Lave-main"),
            ElementsDetail("Evier"),
            ElementsDetail("Bac à douche"),
            ElementsDetail("Chambre de visites  pour eaux vannes"),
            ElementsDetail("Chambre de visites pour eaux usées"),
            ElementsDetail("Réseau d'évacuation pour eau vannes"),
            ElementsDetail("Réseau d'évacuation pour eau usées"),
            ElementsDetail("Réseau d'adduction pour eau pluviales"),
            ElementsDetail("Réseaux d'adduction pour eau potable"),
            ElementsDetail("Vanne d'isolement pour eau potables"),
            ElementsDetail("Robinet équerre pour eaux potables"),
            ElementsDetail("Fosse sceptique"),
        ),
    ),
)

var LIST_COMPOSANT = arrayListOf(
    Composant("Materiel", "Description", R.drawable.composant_materiel, null, LIST_MATERIEL),
    Composant("Fondation", "Description", R.drawable.composant_fondation,LIST_GROUPED_ELEMENT_DATA_FONDATION),
    Composant("Elevation", "Description", R.drawable.composant_elevation, LIST_GROUPED_ELEMENT_DATA_ELEVATION),
    Composant("Toiture", "Description", R.drawable.composant_toiture, LIST_GROUPED_ELEMENT_DATA_TOITURE),
    Composant("Finition", "Description", R.drawable.composant_finition, LIST_GROUPED_ELEMENT_DATA_FINITION),
    Composant("Electricité", "Description", R.drawable.composant_electricite, LIST_GROUPED_ELEMENT_DATA_ELECTRICITE),
    Composant("Menuiserie", "Description", R.drawable.composant_menuiserie, LIST_GROUPED_ELEMENT_DATA_MENUISERIE),
    Composant("Plomberie", "Description", R.drawable.composant_plomberie, LIST_GROUPED_ELEMENT_DATA_PLOMBERIE)
)

var LIST_COMPOSANT1 = arrayListOf(
    Composant("Materiel", "Description", R.drawable.composant_materiel, null, LIST_MATERIEL),
    Composant("Fondation", "Description", R.drawable.composant_fondation,LIST_GROUPED_ELEMENT_DATA_FONDATION),
    Composant("Elevation", "Description", R.drawable.composant_elevation, LIST_GROUPED_ELEMENT_DATA_ELEVATION),
    Composant("Toiture", "Description", R.drawable.composant_toiture, LIST_GROUPED_ELEMENT_DATA_TOITURE),
    Composant("Finition", "Description", R.drawable.composant_finition, LIST_GROUPED_ELEMENT_DATA_FINITION),
    Composant("Electricité", "Description", R.drawable.composant_electricite, LIST_GROUPED_ELEMENT_DATA_ELECTRICITE),
    Composant("Menuiserie", "Description", R.drawable.composant_menuiserie, LIST_GROUPED_ELEMENT_DATA_MENUISERIE),
    Composant("Plomberie", "Description", R.drawable.composant_plomberie, LIST_GROUPED_ELEMENT_DATA_PLOMBERIE)
)

var LIST_COMPOSANT2 = arrayListOf(
    Composant("Materiel", "Description", R.drawable.composant_materiel, null, LIST_MATERIEL),
    Composant("Fondation", "Description", R.drawable.composant_fondation,LIST_GROUPED_ELEMENT_DATA_FONDATION),
    Composant("Elevation", "Description", R.drawable.composant_elevation, LIST_GROUPED_ELEMENT_DATA_ELEVATION),
    Composant("Toiture", "Description", R.drawable.composant_toiture, LIST_GROUPED_ELEMENT_DATA_TOITURE),
    Composant("Finition", "Description", R.drawable.composant_finition, LIST_GROUPED_ELEMENT_DATA_FINITION),
    Composant("Electricité", "Description", R.drawable.composant_electricite, LIST_GROUPED_ELEMENT_DATA_ELECTRICITE),
    Composant("Menuiserie", "Description", R.drawable.composant_menuiserie, LIST_GROUPED_ELEMENT_DATA_MENUISERIE),
    Composant("Plomberie", "Description", R.drawable.composant_plomberie, LIST_GROUPED_ELEMENT_DATA_PLOMBERIE)
)

var LIST_COMPOSANT3 = arrayListOf(
    Composant("Materiel", "Description", R.drawable.composant_materiel, null, LIST_MATERIEL),
    Composant("Fondation", "Description", R.drawable.composant_fondation,LIST_GROUPED_ELEMENT_DATA_FONDATION),
    Composant("Elevation", "Description", R.drawable.composant_elevation, LIST_GROUPED_ELEMENT_DATA_ELEVATION),
    Composant("Toiture", "Description", R.drawable.composant_toiture, LIST_GROUPED_ELEMENT_DATA_TOITURE),
    Composant("Finition", "Description", R.drawable.composant_finition, LIST_GROUPED_ELEMENT_DATA_FINITION),
    Composant("Electricité", "Description", R.drawable.composant_electricite, LIST_GROUPED_ELEMENT_DATA_ELECTRICITE),
    Composant("Menuiserie", "Description", R.drawable.composant_menuiserie, LIST_GROUPED_ELEMENT_DATA_MENUISERIE),
    Composant("Plomberie", "Description", R.drawable.composant_plomberie, LIST_GROUPED_ELEMENT_DATA_PLOMBERIE)
)

var LIST_PROJECTS = listOf(
    ProjectData("Projet Maison DMC", LIST_COMPOSANT),
    ProjectData("Projet Maison Aime", LIST_COMPOSANT1),
    ProjectData("Projet Maison Joel", LIST_COMPOSANT2),
)
