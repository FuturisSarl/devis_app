package com.itverse.futuris.data.entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(tableName = "toiture_table", foreignKeys =
        {@ForeignKey(entity = Project.class, parentColumns = "project_Name", childColumns = "project_ID",
                onDelete = CASCADE, onUpdate = CASCADE)})
public class MaterialToiture {
    @PrimaryKey
    public String project_ID;
    public int toles_sabless;
    public int clou;
    public int chevron;
    public int madrier;

    public MaterialToiture(@NonNull String project_ID, int toles_sabless, int clou, int chevron, int madrier) {
        this.project_ID = project_ID;
        this.toles_sabless = toles_sabless;
        this.clou = clou;
        this.chevron = chevron;
        this.madrier = madrier;
    }
}
