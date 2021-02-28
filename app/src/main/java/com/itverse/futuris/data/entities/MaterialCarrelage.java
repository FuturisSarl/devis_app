package com.itverse.futuris.data.entities;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(tableName = "carrelage_table", foreignKeys =
        {@ForeignKey(entity = Project.class, parentColumns = "project_Name", childColumns = "project_ID",
                onDelete = CASCADE, onUpdate = CASCADE)})
public class MaterialCarrelage {

    @PrimaryKey
    public String project_ID;
    public int ciment;
    public int sable_blanc;

    public MaterialCarrelage(String project_ID, int ciment, int sable_blanc) {
        this.project_ID = project_ID;
        this.ciment = ciment;
        this.sable_blanc = sable_blanc;
    }
}
