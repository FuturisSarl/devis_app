package com.itverse.futuris.data.entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(tableName = "longrine_bq_table", foreignKeys =
        {@ForeignKey(entity = Project.class, parentColumns = "project_Name", childColumns = "project_ID",
                onDelete = CASCADE, onUpdate = CASCADE)})
public class MaterialLongrineBQ {
    @PrimaryKey
    public String project_ID;
    public int ciment;
    public int sable;
    public int gravier;
    public int barre_de_6;
    public int barre_de_10;
    public int fil_de_recuit;
    public int clou;
    public int bois_de_coffrage;
    public int chevron;
    public MaterialLongrineBQ(@NonNull String project_ID, int ciment, int sable, int gravier,
                              int barre_de_6, int barre_de_10, int fil_de_recuit, int clou,
                              int bois_de_coffrage, int chevron) {
        this.project_ID = project_ID;
        this.ciment = ciment;
        this.sable = sable;
        this.gravier = gravier;
        this.barre_de_6 = barre_de_6;
        this.barre_de_10 = barre_de_10;
        this.fil_de_recuit = fil_de_recuit;
        this.clou = clou;
        this.bois_de_coffrage = bois_de_coffrage;
        this.chevron = chevron;
    }
}
