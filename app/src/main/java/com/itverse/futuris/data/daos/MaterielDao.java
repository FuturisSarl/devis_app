package com.itverse.futuris.data.daos;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.itverse.futuris.data.entities.Materiel;

public interface MaterielDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertMateriel(Materiel materiel);
    @Delete
    void deleteMateriel(Materiel materiel);
    @Query("SELECT * FROM materiel_table WHERE materiel_name = :materielName")
    LiveData<Materiel> getMateriel(String materielName);
}
