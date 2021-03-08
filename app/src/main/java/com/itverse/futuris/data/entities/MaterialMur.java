package com.itverse.futuris.data.entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(tableName = "material_mur_table", foreignKeys =
        {@ForeignKey(entity = Project.class, parentColumns = "project_Name", childColumns = "project_ID",
                onDelete = CASCADE, onUpdate = CASCADE)})
public class MaterialMur {
    @PrimaryKey
    public String project_ID;
    public int sable;
    public int ciment;
    public int bloc_creux;

    public MaterialMur(@NonNull String project_Name, int sable, int ciment, int bloc_creux) {
        this.project_ID = project_Name;
        this.sable = sable;
        this.ciment = ciment;
        this.bloc_creux = bloc_creux;
    }
}
