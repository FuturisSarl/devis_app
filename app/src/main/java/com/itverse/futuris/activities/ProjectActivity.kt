package com.itverse.futuris.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.itverse.futuris.*
import com.itverse.futuris.adapters.ProjectRecyclerAdapter
import com.itverse.futuris.data.entities.Project

import com.itverse.futuris.viewModels.ProjectViewModel
import kotlinx.android.synthetic.main.content_activity_project.*

class ProjectActivity : AppCompatActivity() {

    private lateinit var projectViewModel: ProjectViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_project)
        //setSupportActionBar(findViewById(R.id.toolbar))
        projectViewModel = ViewModelProvider(this).get(ProjectViewModel::class.java)
        project_list.layoutManager = GridLayoutManager(this,2)

        // TEST: inserting test data in DB
        insertDataToDatabase()
        if (DataManager.projects.isEmpty())
            loadProjects(this)

        project_list.adapter =
            ProjectRecyclerAdapter(
                this,
                DataManager.projects
            )

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
            val intent = Intent(this, CreateNewProject::class.java)
            this.startActivity(intent)
        }
    }

    private fun insertDataToDatabase() {
        val project = Project("Test1", "composant", 1)
        Toast.makeText(this, "New project created", Toast.LENGTH_LONG).show()
        println("DB: Project saved on database ${project}")

    }

    override fun onResume() {
        super.onResume()
        //val newProject: Int = intent.getIntExtra(EXTRA_NEW_PROJECT_CREATED, NEW_PROJECT_NOT_CREATED)

        //TODO: Only notify data change when a new project is created
        project_list.adapter?.notifyDataSetChanged()
    }
}