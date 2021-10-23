package com.itverse.futuris.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "composant_table")
data class Composant(
    var projectId: Long,
    var name: String,
    var description: String,
    var imageResource: String,
    @field:PrimaryKey(autoGenerate = true)
    var id: Long = 0
)