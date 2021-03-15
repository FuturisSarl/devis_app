package com.itverse.futuris.data.entities;

import android.graphics.Bitmap;

import androidx.room.PrimaryKey;

public class Material {
    @PrimaryKey(autoGenerate = true)
    public int materiel_ID;
    public String materiel_name;
    public int materiel_quantity;
    public Bitmap material_image;

    public Material(int materiel_ID, String materiel_name,
                    int materiel_quantity, Bitmap material_image) {
        this.materiel_ID = materiel_ID;
        this.materiel_name = materiel_name;
        this.materiel_quantity = materiel_quantity;
        this.material_image = material_image;
    }
}
