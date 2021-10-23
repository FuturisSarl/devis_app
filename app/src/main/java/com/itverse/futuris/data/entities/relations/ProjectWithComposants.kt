package com.itverse.futuris.data.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.itverse.futuris.data.entities.Composant
import com.itverse.futuris.data.entities.Project

data class ProjectWithComposants(
    @Embedded
    val project: Project,
    @Relation(
        parentColumn = "id",
        entityColumn = "projectId"
    )
    val composants: List<Composant>,
)