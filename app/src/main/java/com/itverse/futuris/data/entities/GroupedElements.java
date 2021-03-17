package com.itverse.futuris.data.entities;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(tableName = "groupedElement_table", foreignKeys = {
        @ForeignKey(entity = Element.class, parentColumns = "element_name",
                childColumns = "element_ID", onUpdate = CASCADE, onDelete = CASCADE)},
        indices = {@Index(value = {"groupedElement_name"}, unique = true)})
public class GroupedElements {

    @ColumnInfo()
    public String groupedElement_name;
    public String element_ID;
    @PrimaryKey(autoGenerate = true)
    public int id;


    public GroupedElements(String groupedElement_name, String element_ID, int id) {
        this.groupedElement_name = groupedElement_name;
        this.element_ID = element_ID;
        this.id = id;
    }
}
