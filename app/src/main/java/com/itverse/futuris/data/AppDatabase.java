package com.itverse.futuris.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.itverse.futuris.data.daos.ComposantDao;
import com.itverse.futuris.data.daos.ElementsDao;
import com.itverse.futuris.data.daos.GroupedElementsDao;
import com.itverse.futuris.data.daos.MaterielDao;
import com.itverse.futuris.data.daos.ProjectDao;
import com.itverse.futuris.data.entities.Composant;
import com.itverse.futuris.data.entities.Element;
import com.itverse.futuris.data.entities.GroupedElements;
import com.itverse.futuris.data.entities.Materiel;
import com.itverse.futuris.data.entities.Project;

@Database(entities = {Composant.class, Element.class, GroupedElements.class,
        Materiel.class, Project.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public static AppDatabase INSTANCE;

public static AppDatabase getDatabase(final Context context) {

    if (INSTANCE == null){
        synchronized (AppDatabase.class){
            if (INSTANCE == null){
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        AppDatabase.class, "devis_app_database")
                        .fallbackToDestructiveMigration()
                        .build();
            }
        }
    }
    return INSTANCE;
}
//Defining DAOs that work with the Database
public abstract ProjectDao mProjectDao();

}
