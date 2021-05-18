package com.itverse.futuris.data.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.itverse.futuris.data.entities.Element
import com.itverse.futuris.data.entities.relations.ComposantWithGroupedElements
import kotlinx.coroutines.flow.Flow

@Dao
interface ElementsDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(element: Element)

    @Delete
    fun delete(element: Element)

    @get:Query("SELECT * FROM element_table")
    val allElements: LiveData<List<Element>>

    @Query("SELECT * FROM element_table WHERE name = :name")
    fun getElementByName(name: String): LiveData<Element>
}