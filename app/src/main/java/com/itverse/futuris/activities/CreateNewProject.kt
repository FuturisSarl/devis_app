package com.itverse.futuris.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.itverse.futuris.*
import com.itverse.futuris.data.AppDatabase
import com.itverse.futuris.data.entities.Project
import com.itverse.futuris.utils.createProjectFromTemplate
import kotlinx.android.synthetic.main.activity_create_new_project.*
import com.itverse.futuris.utils.getJsonDataFromAsset

class CreateNewProject : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_new_project)

        new_project.setOnClickListener{
            //Creating a new project loads data from a project template JSON file
            val projectName = project_name.text.toString()
            val project = createProjectFromTemplate(this, PROJECT_TEMPLATE_NAME)

            if (project != null) {
                project.name = projectName
                DataManager.projects.add(project)
            }

            //TODO: Project ID should be the taken from the ID generated on the DB
            //Or increment the projectID by the number of project created
            val projectID = 3
            val intent = Intent(this, Composant::class.java)
            intent.putExtra(EXTRA_PROJECT_SELECTED, projectID)
            intent.putExtra(EXTRA_NEW_PROJECT_CREATED, 1)
            this.startActivity(intent)
        }
    }
}