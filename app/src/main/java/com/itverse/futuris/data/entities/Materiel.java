package com.itverse.futuris.data.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity(tableName = "materiel_table")
public class Materiel {
    @PrimaryKey(autoGenerate = true)
    public int materiel_ID;
    public String materiel_name;
    public int materiel_quantity;

    public Materiel(int materiel_ID, String materiel_name,
                    int materiel_quantity) {
        this.materiel_ID = materiel_ID;
        this.materiel_name = materiel_name;
        this.materiel_quantity = materiel_quantity;
    }
}
