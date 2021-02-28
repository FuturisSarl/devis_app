package com.itverse.futuris.data.entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(tableName = "implantation_table", foreignKeys =
        {@ForeignKey(entity = Project.class, parentColumns = "project_Name", childColumns = "project_ID",
                onDelete = CASCADE, onUpdate = CASCADE)})
public class MaterialImplantation {
    @PrimaryKey
    public String project_ID;
    public int chevron;
    public int clou;
    public int ficelle;

    public MaterialImplantation(@NonNull String project_ID, int chevron, int clou, int ficelle) {
        this.project_ID = project_ID;
        this.chevron = chevron;
        this.clou = clou;
        this.ficelle = ficelle;
    }
}
