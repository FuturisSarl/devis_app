package com.itverse.futuris.data.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.itverse.futuris.data.entities.GroupedElements

@Dao
interface GroupedElementsDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertGroupedElement(groupedElement: GroupedElements?)

    @Delete
    fun deleteGroupedElement(groupedElement: GroupedElements?)

    @Query("SELECT * FROM groupedElement_table WHERE name = :name ")
    fun getGroupedElement(name: String?): LiveData<GroupedElements?>?
}