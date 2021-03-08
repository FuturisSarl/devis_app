package com.itverse.futuris.data.entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(tableName = "beton_table", foreignKeys =
        {@ForeignKey(entity = Project.class, parentColumns = "project_Name", childColumns = "project_ID",
                onDelete = CASCADE, onUpdate = CASCADE)})
public class MaterialBeton {
    public String project_ID;
    public int ciment;
    public int sable;
    public int gravier;

    public MaterialBeton(@NonNull String project_ID, int ciment, int sable, int gravier) {
        this.project_ID = project_ID;
        this.ciment = ciment;
        this.sable = sable;
        this.gravier = gravier;
    }
}
