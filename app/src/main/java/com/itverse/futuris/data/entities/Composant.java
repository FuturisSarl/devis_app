package com.itverse.futuris.data.entities;

import android.graphics.Bitmap;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(tableName = "composant_table", foreignKeys = {
        @ForeignKey(entity = GroupedElements.class, parentColumns = "groupedElement_name",
                childColumns = "groupedElement_ID", onDelete = CASCADE, onUpdate = CASCADE),
        @ForeignKey(entity = Material.class, parentColumns = "materiel_ID",
                        childColumns = "materiel_ID", onDelete = CASCADE, onUpdate = CASCADE)})
public class Composant {
    @PrimaryKey(autoGenerate = true)
    public String composant_name;
    public String composant_description;
    public Bitmap compsant_image;
    public String groupedElement_ID;
    public int materiel_ID;


    public Composant(@NonNull String composant_name, String composant_description, Bitmap compsant_image,
                     String groupedElement_ID, int materiel_ID) {
        this.composant_name = composant_name;
        this.composant_description = composant_description;
        this.compsant_image = compsant_image;
        this.groupedElement_ID = groupedElement_ID;
        this.materiel_ID = materiel_ID;
    }
}
