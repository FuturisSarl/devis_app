package com.itverse.futuris.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ColumnInfo

@Entity(tableName = "groupedElement_table")
data class GroupedElements(
    @field:ColumnInfo
    var name: String,
    var composantId: Int,
    @field:PrimaryKey(autoGenerate = true)
    var id: Int = 0
)