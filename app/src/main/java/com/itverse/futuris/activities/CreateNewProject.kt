package com.itverse.futuris.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.itverse.futuris.*
import com.itverse.futuris.data.AppDatabase
import com.itverse.futuris.data.entities.Project
import kotlinx.android.synthetic.main.activity_create_new_project.*
import com.itverse.futuris.utils.getJsonDataFromAsset

class CreateNewProject : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_new_project)
        val database = AppDatabase.getDatabase(this)

        new_project.setOnClickListener{
            //Creating a new project loads data from a project template JSON file
            val projectName = project_name.text.toString()

            DataManager.projects.add(
                ProjectData(projectName, LIST_COMPOSANT3)
            )

            val composants = ArrayList<Composant>()
            //val project = Project(projectName)
            //database.mProjectDao().insertProject(project)
            val response = getJsonDataFromAsset(this, "template_1.json")

            //TODO: Project ID should be the taken from the ID generated on the DB
            val projectID = 3
            val intent = Intent(this, Composant::class.java)
            intent.putExtra(EXTRA_PROJECT_SELECTED, projectID)
            intent.putExtra(EXTRA_NEW_PROJECT_CREATED, 1)
            this.startActivity(intent)
        }
    }
}