package com.itverse.futuris.data.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.itverse.futuris.data.entities.Element
import com.itverse.futuris.data.entities.GroupedElements

data class GroupedElementsWithElements(
    @Embedded
    val groupedElement: GroupedElements,
    @Relation(
        parentColumn = "id",
        entityColumn = "groupedElementId"
    )
    val elements: List<Element>
)
