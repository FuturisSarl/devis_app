package com.itverse.futuris.data.entities

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "materiel_table", indices = [Index(value = ["materiel_ID"], unique = true)])
data class Materiel(
    var materiel_ID: Int,
    var materiel_name: String,
    var materiel_quantity: Int,
    @field:PrimaryKey(autoGenerate = true)
    var id: Int
)