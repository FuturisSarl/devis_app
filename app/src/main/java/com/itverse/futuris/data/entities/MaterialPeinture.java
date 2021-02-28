package com.itverse.futuris.data.entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(tableName = "peinture_table", foreignKeys =
        {@ForeignKey(entity = Project.class, parentColumns = "project_Name", childColumns = "project_ID",
                onDelete = CASCADE, onUpdate = CASCADE)})
public class MaterialPeinture {
    @PrimaryKey
    public String project_ID;
    public int surface_a_peindre;
    public int peinture_a_eau;
    public String[] accessoires;

    public MaterialPeinture(@NonNull String project_ID, int surface_a_peindre, int peinture_a_eau, String[] accessoires) {
        this.project_ID = project_ID;
        this.surface_a_peindre = surface_a_peindre;
        this.peinture_a_eau = peinture_a_eau;
        this.accessoires = accessoires;
    }
}
