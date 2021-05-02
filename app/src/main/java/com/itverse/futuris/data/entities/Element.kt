package com.itverse.futuris.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "element_table")
data class Element(
    var name: String,
    var unit: String,
    var value: String,
    var GroupedElementId: Int,
    @field:PrimaryKey(autoGenerate = true)
    var id: Int = 0
)