package com.itverse.futuris.data.daos

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.itverse.futuris.data.entities.Materiel

interface MaterielDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertMateriel(materiel: Materiel?)

    @Delete
    fun deleteMateriel(materiel: Materiel?)

    @Query("SELECT * FROM materiel_table WHERE name = :name")
    fun getMateriel(name: String?): LiveData<Materiel?>?
}