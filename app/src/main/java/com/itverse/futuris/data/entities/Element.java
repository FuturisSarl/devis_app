package com.itverse.futuris.data.entities;


import androidx.room.Entity;

@Entity(tableName = "element_table")
public class Element {

    public String element_name;
    public String element_unit;
    public String element_value;

    public Element(String element_name, String element_unit, String element_value) {
        this.element_name = element_name;
        this.element_unit = element_unit;
        this.element_value = element_value;
    }
}
