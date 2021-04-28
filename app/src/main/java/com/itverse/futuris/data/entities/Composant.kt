package com.itverse.futuris.data.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "composant_table",
    foreignKeys = [ForeignKey(
        entity = GroupedElements::class,
        parentColumns = arrayOf("groupedElement_name"),
        childColumns = arrayOf("groupedElement_ID"),
        onDelete = ForeignKey.CASCADE,
        onUpdate = ForeignKey.CASCADE
    ), ForeignKey(
        entity = Materiel::class,
        parentColumns = arrayOf("materiel_ID"),
        childColumns = arrayOf("materiel_ID"),
        onDelete = ForeignKey.CASCADE,
        onUpdate = ForeignKey.CASCADE
    )],
    indices = [Index(value = ["composant_name"], unique = true)]
)
class Composant(
    var composant_name: String,
    var composant_description: String,
    var groupedElement_ID: String,
    var materiel_ID: Int,
    @field:PrimaryKey(autoGenerate = true)
    var id: Int
)