package com.itverse.futuris.data.entities;


import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "element_table", indices = {@Index(value = {"element_name"}, unique = true)})
public class Element {

    public String element_name;
    public String element_unit;
    public String element_value;
    @PrimaryKey(autoGenerate = true)
    public int id;

    public Element(String element_name, String element_unit, String element_value, int id) {
        this.element_name = element_name;
        this.element_unit = element_unit;
        this.element_value = element_value;
        this.id = id;
    }
}
