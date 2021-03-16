package com.itverse.futuris.data.daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.itverse.futuris.data.entities.Composant;

import java.util.List;

@Dao
public interface ComposantDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertComposant(Composant composant);
    @Delete
    void deleteComposant(Composant composant);
    @Query("SELECT * FROM composant_table WHERE composant_name = :composantName")
    LiveData<Composant> getComposant(String composantName);
    @Query("SELECT * FROM composant_table")
    LiveData<List<Composant>> getAllComposant();
}
