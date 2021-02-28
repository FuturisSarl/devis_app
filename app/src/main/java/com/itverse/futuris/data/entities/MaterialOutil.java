package com.itverse.futuris.data.entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(tableName = "tools_table", foreignKeys =
        {@ForeignKey(entity = Project.class, parentColumns = "project_Name", childColumns = "project_ID",
                onDelete = CASCADE, onUpdate = CASCADE)})
public class MaterialOutil {
    @PrimaryKey
    public String project_ID;
    public int marteau_tenaille;
    public int marteau_masse;
    public int tenaille;
    public int brouette;
    public int gamate;
    public int equerre;
    public int machette;
    public int niveau_eau;
    public int fut_eau;
    public int pelle;
    public int pioche;
    public int monture_scie;
    public int lame_scie;

    public MaterialOutil(@NonNull String project_ID, int marteau_tenaille, int marteau_masse, int tenaille,
                         int brouette, int gamate, int equerre, int machette, int niveau_eau,
                         int fut_eau, int pelle, int pioche, int monture_scie, int lame_scie) {
        this.project_ID = project_ID;
        this.marteau_tenaille = marteau_tenaille;
        this.marteau_masse = marteau_masse;
        this.tenaille = tenaille;
        this.brouette = brouette;
        this.gamate = gamate;
        this.equerre = equerre;
        this.machette = machette;
        this.niveau_eau = niveau_eau;
        this.fut_eau = fut_eau;
        this.pelle = pelle;
        this.pioche = pioche;
        this.monture_scie = monture_scie;
        this.lame_scie = lame_scie;
    }
}
