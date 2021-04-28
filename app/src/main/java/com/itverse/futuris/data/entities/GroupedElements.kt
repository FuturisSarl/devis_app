package com.itverse.futuris.data.entities

import androidx.room.*

@Entity(
    tableName = "groupedElement_table",
    foreignKeys = [ForeignKey(
        entity = Element::class,
        parentColumns = arrayOf("element_name"),
        childColumns = arrayOf("element_ID"),
        onUpdate = ForeignKey.CASCADE,
        onDelete = ForeignKey.CASCADE
    )],
    indices = [Index(value = ["groupedElement_name"], unique = true)]
)
class GroupedElements(
    @field:ColumnInfo
    var groupedElement_name: String,
    var element_ID: String,
    @field:PrimaryKey(autoGenerate = true)
    var id: Int
)