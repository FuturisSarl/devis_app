package com.itverse.futuris.data.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.itverse.futuris.data.entities.Composant
import com.itverse.futuris.data.entities.Materiel

data class ComposantWithMateriels(
    @Embedded
    val composant: Composant,
    @Relation(
        parentColumn = "id",
        entityColumn = "composantId"
    )
    val elements: List<Materiel>
)