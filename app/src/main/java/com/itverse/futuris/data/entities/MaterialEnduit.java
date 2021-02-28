package com.itverse.futuris.data.entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(tableName = "enduit_table", foreignKeys =
        {@ForeignKey(entity = Project.class, parentColumns = "project_Name", childColumns = "project_ID",
                onDelete = CASCADE, onUpdate = CASCADE)})
public class MaterialEnduit {
    @PrimaryKey
    public String project_ID;
    public int sable;
    public int ciment;

    public MaterialEnduit(@NonNull String project_ID, int sable, int ciment) {
        this.project_ID = project_ID;
        this.sable = sable;
        this.ciment = ciment;
    }
}
