package com.itverse.futuris.data.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.itverse.futuris.data.entities.Element

@Dao
interface ElementsDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertElement(element: Element?)

    @Delete
    fun deleteElement(element: Element?)

    @get:Query("SELECT * FROM element_table")
    val allElements: LiveData<List<Element?>?>?

    @Query("SELECT * FROM element_table WHERE name = :name")
    fun getElementByName(name: String?): LiveData<Element?>?
}