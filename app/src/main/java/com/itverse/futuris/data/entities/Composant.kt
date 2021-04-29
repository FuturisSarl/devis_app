package com.itverse.futuris.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "composant_table")
data class Composant(
    @field:PrimaryKey(autoGenerate = true)
    var id: Int,
    var projectId: Int,
    var name: String,
    var description: String,
    var imageResource: String
)