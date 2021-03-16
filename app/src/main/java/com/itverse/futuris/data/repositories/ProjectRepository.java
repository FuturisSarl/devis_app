package com.itverse.futuris.data.repositories;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.itverse.futuris.data.AppDatabase;
import com.itverse.futuris.data.daos.ProjectDao;
import com.itverse.futuris.data.entities.Project;

import java.util.List;

@SuppressWarnings("ALL")
public class ProjectRepository {

    private ProjectDao mProjectDao;
    LiveData<List<Project>> mAllProjects;
    ProjectRepository(Application application) {
       AppDatabase database = AppDatabase.getDatabase(application);
       mProjectDao = database.mProjectDao();
       mAllProjects = mProjectDao.getAllProjects();
    }
    public LiveData<List<Project>> getAllProjects(){
        return mAllProjects;
    }
    public void insertProject(Project projectName){
        new insertAsyncTask(mProjectDao).execute(projectName);
    }



    //Insert a new project in the background
    public class insertAsyncTask extends AsyncTask<Project, Void, Void>{

        private ProjectDao mAsyncTaskProjectDao;
        public insertAsyncTask(ProjectDao projectDao){
            this.mAsyncTaskProjectDao = projectDao;
        }
        @Override
        protected Void doInBackground(Project... projects) {
            mAsyncTaskProjectDao.insertProject(projects[0]);
            return null;
        }
    }


}
