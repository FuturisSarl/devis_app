package com.itverse.futuris.data.daos

import androidx.room.*
import com.itverse.futuris.data.entities.Materiel
import kotlinx.coroutines.flow.Flow

@Dao
interface MaterielDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(materiel: Materiel): Long

    @Delete
    suspend fun delete(materiel: Materiel)

    @Query("SELECT * FROM materiel_table WHERE name = :name")
    suspend fun get(name: String?): Materiel

    @Query("UPDATE materiel_table SET quantity = quantity + 1  WHERE id = :materielId")
    suspend fun increment(materielId: Long): Int

    @Query("UPDATE materiel_table SET quantity = quantity - 1  WHERE id = :materielId")
    suspend fun decrement(materielId: Long): Int

    @Query("SELECT * FROM materiel_table WHERE composantId = :composantId")
    fun getAllMaterielsFrom(composantId: Long): Flow<List<Materiel>>

    @Query("SELECT * FROM materiel_table WHERE composantId = :composantId")
    suspend fun getAllMaterielsFrom_(composantId: Long): List<Materiel>

    @Query("SELECT * FROM materiel_table WHERE composantId = :composantId")
    suspend fun getAllListFrom(composantId: Long): List<Materiel>

}