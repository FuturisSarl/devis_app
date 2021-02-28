package com.itverse.futuris.data.entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(tableName = "material_moellon_table", foreignKeys =
        {@ForeignKey(entity = Project.class, parentColumns = "project_Name", childColumns = "project_ID",
                onDelete = CASCADE, onUpdate = CASCADE)})
public class MaterialMaconnerieMoellon {
    @PrimaryKey
    public String project_ID;
    public int sable;
    public int ciment;
    public int moellon;

    public MaterialMaconnerieMoellon(@NonNull String project_ID, int sable, int ciment, int moellon) {
        this.project_ID = project_ID;
        this.sable = sable;
        this.ciment = ciment;
        this.moellon = moellon;
    }
}

