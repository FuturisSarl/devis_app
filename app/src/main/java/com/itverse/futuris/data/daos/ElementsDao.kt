package com.itverse.futuris.data.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.itverse.futuris.data.entities.Element
import com.itverse.futuris.data.entities.relations.ComposantWithGroupedElements
import kotlinx.coroutines.flow.Flow

@Dao
interface ElementsDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(element: Element)

    @Delete
    suspend fun delete(element: Element)

    @get:Query("SELECT * FROM element_table")
    val allElements: LiveData<List<Element>>

    @Query("UPDATE element_table SET value = :value WHERE id = :elementId")
    suspend fun updateQuantity(elementId: Long, value: Int): Int

    @Query("SELECT * FROM element_table WHERE name = :name")
    fun getElementByName(name: String): LiveData<Element>
}