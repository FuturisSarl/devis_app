package com.itverse.futuris.data.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.itverse.futuris.data.entities.Composant

@Dao
interface ComposantDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertComposant(composant: Composant?)

    @Delete
    fun deleteComposant(composant: Composant?)

    @Query("SELECT * FROM composant_table WHERE composant_name = :composantName")
    fun getComposant(composantName: String?): LiveData<Composant?>?

    @get:Query("SELECT * FROM composant_table")
    val allComposant: LiveData<List<Composant?>?>?
}