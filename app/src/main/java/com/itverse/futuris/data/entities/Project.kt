package com.itverse.futuris.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "project_table")
data class Project(
    var name: String,
    @field:PrimaryKey(autoGenerate = true)
    var id: Int = 0
    )