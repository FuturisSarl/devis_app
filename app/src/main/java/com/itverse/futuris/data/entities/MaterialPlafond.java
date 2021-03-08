package com.itverse.futuris.data.entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(tableName = "plafond_table", foreignKeys =
        {@ForeignKey(entity = Project.class, parentColumns = "project_Name", childColumns = "project_ID",
                onDelete = CASCADE, onUpdate = CASCADE)})
public class MaterialPlafond {
    @PrimaryKey
    public String project_ID;
    public boolean faux_plafond;
    public String[] accessoires;

    public MaterialPlafond(@NonNull String project_ID, boolean faux_plafond, String[] accessoires) {
        this.project_ID = project_ID;
        this.faux_plafond = faux_plafond;
        this.accessoires = accessoires;
    }
}
