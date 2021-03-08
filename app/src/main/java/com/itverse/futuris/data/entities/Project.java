package com.itverse.futuris.data.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "project_table")
public class Project {
    @PrimaryKey
    public String project_Name;
}
