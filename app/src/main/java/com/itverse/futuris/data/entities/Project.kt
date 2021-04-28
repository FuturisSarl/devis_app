package com.itverse.futuris.data.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "project_table",
    foreignKeys = [ForeignKey(
        entity = Composant::class,
        parentColumns = arrayOf("composant_name"),
        childColumns = arrayOf("composant_ID"),
        onDelete = ForeignKey.CASCADE,
        onUpdate = ForeignKey.CASCADE
    )]
)
class Project(
    var project_name: String,
    var composant_ID: String,
    @field:PrimaryKey(autoGenerate = true)
    var id: Int
    )