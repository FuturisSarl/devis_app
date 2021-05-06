package com.itverse.futuris.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "materiel_table")
data class Materiel(
    var composantId: Long,
    var name: String,
    var imageResource: String,
    var quantity: Int = 0,
    @field:PrimaryKey(autoGenerate = true)
    var id: Long = 0
)