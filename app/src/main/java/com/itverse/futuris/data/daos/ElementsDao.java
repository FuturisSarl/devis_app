package com.itverse.futuris.data.daos;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.itverse.futuris.data.entities.Element;

import java.util.List;

public interface ElementsDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertElement(Element element);
    @Delete
    void deleteElement(Element element);
    @Query("SELECT * FROM element_table")
    LiveData<List<Element>> getAllElements();
    @Query("SELECT * FROM element_table WHERE element_name = :elementName")
    LiveData<Element> getElementByName(String elementName);


}
