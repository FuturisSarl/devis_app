package com.itverse.futuris.data.entities

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "materiel_table")
data class Materiel(
    var name: String,
    var quantity: Int,
    var imageResource: String,
    @field:PrimaryKey(autoGenerate = true)
    var id: Int
)