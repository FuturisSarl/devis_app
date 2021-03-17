package com.itverse.futuris.data.entities;

import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;
@Entity(tableName = "materiel_table", indices = {@Index(value = {"materiel_ID"}, unique = true)})
public class Materiel {
    public int materiel_ID;
    public String materiel_name;
    public int materiel_quantity;
    @PrimaryKey(autoGenerate = true)
    public int id;

    public Materiel(int materiel_ID, String materiel_name,
                    int materiel_quantity, int id) {
        this.materiel_ID = materiel_ID;
        this.materiel_name = materiel_name;
        this.materiel_quantity = materiel_quantity;
        this.id = id;
    }
}
