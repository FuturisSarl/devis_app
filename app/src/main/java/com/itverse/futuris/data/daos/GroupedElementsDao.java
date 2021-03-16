package com.itverse.futuris.data.daos;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.itverse.futuris.data.entities.GroupedElements;

public interface GroupedElementsDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertGroupedElement(GroupedElements groupedElement);
    @Delete
    void deleteGroupedElement(GroupedElements groupedElement);
    @Query("SELECT * FROM groupedElement_table WHERE groupedElement_name = :groupedElementsName ")
    LiveData<GroupedElements> getGroupedElement(GroupedElements groupedElementsName);

}
