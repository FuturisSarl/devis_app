package com.itverse.futuris.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.itverse.futuris.*
import kotlinx.android.synthetic.main.activity_create_new_project.*

class CreateNewProject : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_new_project)
        new_project.setOnClickListener{
            //Creating a new project loads data from a project template JSON file
            val projectName = project_name.text
            DataManager.projects.add(
                ProjectData(projectName.toString(), LIST_COMPOSANT3)
            )
            //TODO: Project ID should be the taken from the ID generated on the DB
            val projectID = 3
            val intent = Intent(this, Composant::class.java)
            intent.putExtra(EXTRA_PROJECT_SELECTED, projectID)
            intent.putExtra(EXTRA_NEW_PROJECT_CREATED, 1)
            this.startActivity(intent)
        }
    }
}