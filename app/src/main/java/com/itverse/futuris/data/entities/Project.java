package com.itverse.futuris.data.entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(tableName = "project_table", foreignKeys =
        {@ForeignKey(entity = Composant.class, parentColumns = "composant_name",
                childColumns = "composant_ID", onDelete = CASCADE, onUpdate = CASCADE)})
public class Project {
    public String project_Name;
    public String composant_ID;
    @PrimaryKey(autoGenerate = true)
    public int id;

    public Project(@NonNull String project_Name, @NonNull String composant_ID, int id) {
        this.project_Name = project_Name;
        this.composant_ID = composant_ID;
        this.id = id;
    }
}
