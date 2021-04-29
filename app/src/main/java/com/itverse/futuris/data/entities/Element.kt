package com.itverse.futuris.data.entities

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "element_table", indices = [Index(value = ["element_name"], unique = true)])
data class Element(
    var element_name: String,
    var element_unit: String,
    var element_value: String,
    @field:PrimaryKey(autoGenerate = true)
    var id: Int
)