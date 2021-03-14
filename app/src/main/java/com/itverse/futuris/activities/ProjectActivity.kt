package com.itverse.futuris.activities

import android.content.Intent
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.itverse.futuris.*
import com.itverse.futuris.adapters.ProjectRecyclerAdapter
import kotlinx.android.synthetic.main.content_activity_project.*

class ProjectActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_project)
        //setSupportActionBar(findViewById(R.id.toolbar))

        project_list.layoutManager = GridLayoutManager(this,2)
        project_list.adapter =
            ProjectRecyclerAdapter(
                this,
                DataManager.projects
            )

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            val intent = Intent(this, CreateNewProject::class.java)
            this.startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        //println("Resuming")
        //val newProject: Int = intent.getIntExtra(EXTRA_NEW_PROJECT_CREATED, NEW_PROJECT_NOT_CREATED)
        //println(newProject)
        //TODO: Only notify data change when a new project is created
        project_list.adapter?.notifyDataSetChanged()
    }
}