package com.itverse.futuris.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.google.android.material.floatingactionbutton.FloatingActionButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.itverse.futuris.R
import com.itverse.futuris.FuturisApplication
import com.itverse.futuris.adapters.ProjectRecyclerAdapter
import com.itverse.futuris.mViewModels.ProjectViewModel
import com.itverse.futuris.mViewModels.ProjectViewModelFactory
import kotlinx.android.synthetic.main.content_activity_project.*

class ProjectActivity : AppCompatActivity() {

    private val projectViewModel: ProjectViewModel by viewModels {
        ProjectViewModelFactory((application as FuturisApplication).repository)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_project)
        val adapter = ProjectRecyclerAdapter(this)
        project_list.layoutManager = GridLayoutManager(this,2)

        projectViewModel.allProjects.observe(this) { projects ->
            // Update the cached copy of the project in the adapter.
            projects.let { adapter.submitList(it) }
        }

        project_list.adapter = adapter

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
            val intent = Intent(this, CreateNewProject::class.java)
            this.startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        //val newProject: Int = intent.getIntExtra(EXTRA_NEW_PROJECT_CREATED, NEW_PROJECT_NOT_CREATED)

        //TODO: Only notify data change when a new project is created
        project_list.adapter?.notifyDataSetChanged()
    }
}