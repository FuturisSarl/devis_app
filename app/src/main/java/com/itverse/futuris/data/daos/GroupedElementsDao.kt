package com.itverse.futuris.data.daos

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.itverse.futuris.data.entities.GroupedElements

interface GroupedElementsDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertGroupedElement(groupedElement: GroupedElements?)

    @Delete
    fun deleteGroupedElement(groupedElement: GroupedElements?)

    @Query("SELECT * FROM groupedElement_table WHERE name = :name ")
    fun getGroupedElement(name: String?): LiveData<GroupedElements?>?
}