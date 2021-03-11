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
            ElementsDetailData("Nombre de socles"),
            ElementsDetailData("Section du socle"),
            ElementsDetailData("Perimètre de la section"),
            ElementsDetailData("Hauteur du socle"),
            ElementsDetailData("Nombre d'étrier/socles"),
            ElementsDetailData("Nombre de barre/socles"),
            ElementsDetailData("Volume total du béton"),

        ),
    ),
    GroupedElementsData(
        "Longrine en BQ",
        arrayListOf(
            ElementsDetailData("Mettre linéaire de la longrine"),
            ElementsDetailData("Section de la longrine"),
            ElementsDetailData("Périmètre de la section"),
            ElementsDetailData("Nombre d'étrier/poutre"),
            ElementsDetailData("Nombre de barre/longrine"),
            ElementsDetailData("Volume total du béton"),
        ),
    ),
    GroupedElementsData(
        title = "Maconnerie en moellon",
        arrayListOf(
            ElementsDetailData("Mettre linéaire de la fondation"),
        ),
    ),
)

var LIST_GROUPED_ELEMENT_DATA_ELEVATION = arrayListOf(
        GroupedElementsData(
            "Collones en B.A",
            arrayListOf(
                ElementsDetailData("Nombre de collones"),
                ElementsDetailData("Perimètre de la section"),
                ElementsDetailData("Hauteur de la colonne(moyenne)"),
                ElementsDetailData("Nombre de barre/colonnes"),
            ),
        ),
        GroupedElementsData(
            "Poutre en B.A",
            arrayListOf(
                ElementsDetailData("Mettre linéaire de la poutre"),
                ElementsDetailData("Section de la poutre"),
                ElementsDetailData("Perimètre de la section"),
                ElementsDetailData("Nombre d'étrier/poutre"),
                ElementsDetailData("Nombre de barre/poutre"),
                ElementsDetailData("Volume total du béton"),
            ),
        ),
        GroupedElementsData(
            "Maconnerie",
            arrayListOf(
                ElementsDetailData("Mur"),
            ),
        ),
)

var LIST_GROUPED_ELEMENT_DATA_TOITURE= arrayListOf(
        GroupedElementsData(
            "Couverture",
            arrayListOf(
                ElementsDetailData("Surface à couvrir"),
            ),
        ),
)
var LIST_GROUPED_ELEMENT_DATA_FINITION= arrayListOf(
        GroupedElementsData(
            "Carrelage",
            arrayListOf(
                ElementsDetailData("Carreaux (60*60)"),
                ElementsDetailData("Carreaux anti-dépadant(30cm*30cm)"),
                ElementsDetailData("Faiences(30cm*15cm)"),
            ),
        ),
        GroupedElementsData(
            "Peinture",
            arrayListOf(

            ),
        ),
        GroupedElementsData(
            "Plafond",
            arrayListOf(
                ElementsDetailData("Faux plafond et accessoires"),

            ),
        ),
        GroupedElementsData(
            "Enduit(Entry, positive integer)",
            arrayListOf(

            ),
        ),
)

var LIST_GROUPED_ELEMENT_DATA_ELECTRICITE= arrayListOf(
        GroupedElementsData(
            "Carrelage",
            arrayListOf(
                ElementsDetailData("Lustre salon"),
                ElementsDetailData("LUstre salle à manger"),
                ElementsDetailData("Plafonnier encastré pour cuisine"),
                ElementsDetailData("Spots encastrés"),
                ElementsDetailData("Applique murale"),
                ElementsDetailData("PLafonnier encastré pour salle d'eau"),
                ElementsDetailData("Socket(generated)"),
                ElementsDetailData("Interrupteur encastrée simple direction"),
                ElementsDetailData("Interrupteur encastrée double direction"),
                ElementsDetailData("Interrupteur bipolaire encastrée double direction"),
                ElementsDetailData("Prises type poste de travail"),
                ElementsDetailData("Prise encastrée avec terre"),
                ElementsDetailData("Prises encastrée hermetique avec terre"),
                ElementsDetailData("Prises encastrée télé"),
                ElementsDetailData("Réseau d'alimentation des climatiseurs "),
                ElementsDetailData("Réseau d'alimentation des prises"),
                ElementsDetailData("Réseau d'alimentation des points limineux"),
                ElementsDetailData("Tableau divisionnaire et accessoire"),
                ElementsDetailData("Carreaux anti-dépadant(30cm*30cm)"),



        ),
    ),
)
var LIST_GROUPED_ELEMENT_DATA_MENUISERIE= arrayListOf(
        GroupedElementsData(
            "TYPES PORTES",
            arrayListOf(
                ElementsDetailData("Porte (80cm*250cm-Bois)"),
                ElementsDetailData("Porte (90cm*250cm-Bois)"),
                ElementsDetailData("Porte d'entrée principale (300cm*250cm)-Métal"),
            ),
        ),
        GroupedElementsData(
            "TYPE FENETRE",
            arrayListOf(

                ElementsDetailData("Fenêtre-type1(150cm*200cm-Métal)"),
                ElementsDetailData("Fenêtre-type2(200cm*200cm-Métal)"),
                ElementsDetailData("Fenêtre-salle à manger(1500cm*200cm)-Métal"),

            ),
        ),
        GroupedElementsData(
            "TYPE IMPOSTES",
            arrayListOf(
                ElementsDetailData("Imposte(60cm*60cm)"),
            ),
        ),
)

var LIST_GROUPED_ELEMENT_DATA_PLOMBERIE= arrayListOf(
    GroupedElementsData(
        "Plomberie de la maison de benjamin",
        arrayListOf(
            ElementsDetailData("Cuve"),
            ElementsDetailData("Lave-main"),
            ElementsDetailData("Evier"),
            ElementsDetailData("Bac à douche"),
            ElementsDetailData("Chambre de visites  pour eaux vannes"),
            ElementsDetailData("Chambre de visites pour eaux usées"),
            ElementsDetailData("Réseau d'évacuation pour eau vannes"),
            ElementsDetailData("Réseau d'évacuation pour eau usées"),
            ElementsDetailData("Réseau d'adduction pour eau pluviales"),
            ElementsDetailData("Réseaux d'adduction pour eau potable"),
            ElementsDetailData("Vanne d'isolement pour eau potables"),
            ElementsDetailData("Robinet équerre pour eaux potables"),
            ElementsDetailData("Fosse sceptique"),
        ),
    ),
)

var LIST_COMPOSANT = arrayListOf(
    ComposantData("Matériel", "Description", R.drawable.composant_materiel, null, materiels =LIST_MATERIEL_ELEMENTS),
    ComposantData("Fondation", "Description", R.drawable.composant_fondation,LIST_GROUPED_ELEMENT_DATA_FONDATION),
    ComposantData("Elevation", "Description", R.drawable.composant_elevation, LIST_GROUPED_ELEMENT_DATA_ELEVATION),
    ComposantData("Toiture", "Description", R.drawable.composant_toiture, LIST_GROUPED_ELEMENT_DATA_TOITURE),
    ComposantData("Finition", "Description", R.drawable.composant_finition, LIST_GROUPED_ELEMENT_DATA_FINITION),
    ComposantData("Electricité", "Description", R.drawable.composant_electricite, LIST_GROUPED_ELEMENT_DATA_ELECTRICITE),
    ComposantData("Menuiserie", "Description", R.drawable.composant_menuiserie, LIST_GROUPED_ELEMENT_DATA_MENUISERIE),
    ComposantData("Plomberie", "Description", R.drawable.composant_plomberie, LIST_GROUPED_ELEMENT_DATA_PLOMBERIE)
)


var LIST_PROJECTS = listOf(
    ProjectData("Projet Maison DMC", LIST_COMPOSANT ),
    ProjectData("Projet Maison Aime", LIST_COMPOSANT),
    ProjectData("Projet Maison Joel", LIST_COMPOSANT),
    ProjectData("Projet Maison Espe", LIST_COMPOSANT),
)
