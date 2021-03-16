package com.itverse.futuris.data.entities;


import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(tableName = "groupedElement_table", foreignKeys = {
        @ForeignKey(entity = Element.class, parentColumns = "element_name",
                childColumns = "element_ID", onUpdate = CASCADE, onDelete = CASCADE)
})
public class GroupedElements {

    @PrimaryKey(autoGenerate = true)
    public String groupedElement_name;
    public String element_ID;


    public GroupedElements(String groupedElement_name, String element_ID) {
        this.groupedElement_name = groupedElement_name;
        this.element_ID = element_ID;
    }
}
