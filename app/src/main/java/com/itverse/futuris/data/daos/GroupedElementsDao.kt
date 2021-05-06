package com.itverse.futuris.data.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.itverse.futuris.data.entities.GroupedElements

@Dao
interface GroupedElementsDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(groupedElement: GroupedElements?): Long

    @Delete
    fun delete(groupedElement: GroupedElements?)

    @Query("SELECT * FROM groupedElement_table WHERE name = :name ")
    fun get(name: String?): LiveData<GroupedElements?>?
}