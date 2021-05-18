package com.itverse.futuris.data.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.itverse.futuris.data.entities.GroupedElements
import com.itverse.futuris.data.entities.Materiel
import com.itverse.futuris.data.entities.relations.ComposantWithGroupedElements
import com.itverse.futuris.data.entities.relations.GroupedElementsWithElements
import kotlinx.coroutines.flow.Flow

@Dao
interface GroupedElementsDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(groupedElement: GroupedElements?): Long

    @Delete
    fun delete(groupedElement: GroupedElements?)

    // TODO: Is this query important?
    // get an grouped element for a given name
    @Query("SELECT * FROM groupedElement_table WHERE name = :name ")
    fun get(name: String): LiveData<GroupedElements>

    // Only get the grouped elements details for a given composant
    @Query("SELECT * FROM groupedElement_table WHERE composantId = :composantId")
    fun getAllFrom(composantId: Long): Flow<List<GroupedElements>>

    // Get the Grouped elements with their elements for a given composant
    @Transaction
    @Query("SELECT * FROM groupedElement_table WHERE composantId = :composantId")
    fun getAllWithElementsFrom(composantId: Long): Flow<List<GroupedElementsWithElements>>

}