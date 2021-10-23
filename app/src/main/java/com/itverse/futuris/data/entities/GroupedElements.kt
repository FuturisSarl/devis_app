package com.itverse.futuris.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ColumnInfo

@Entity(tableName = "groupedElement_table")
data class GroupedElements(
    var composantId: Long,
    @field:ColumnInfo
    var name: String,
    @field:PrimaryKey(autoGenerate = true)
    var id: Long = 0
)