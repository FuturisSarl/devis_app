package com.itverse.futuris.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.itverse.futuris.*
import com.itverse.futuris.mViewModels.*
import com.itverse.futuris.utils.*
import androidx.lifecycle.viewModelScope
import com.itverse.futuris.data.entities.Materiel
import kotlinx.coroutines.*
import kotlinx.coroutines.launch
import kotlinx.android.synthetic.main.activity_create_new_project.*

class CreateNewProject : AppCompatActivity() {

    private val composantViewModel: ComposantViewModel by viewModels {
        ComposantViewModelFactory((application as FuturisApplication).composantRepository)
    }

    private val projectViewModel: ProjectViewModel by viewModels {
        ProjectViewModelFactory((application as FuturisApplication).repository)
    }

    private val materielViewModel: MaterielViewModel by viewModels {
        MaterielViewModelFactory((application as FuturisApplication).materielRepository)
    }

    private val groupedElementsViewModel: GroupedElementsViewModel by viewModels {
        GroupedElementsViewModelFactory((application as FuturisApplication).groupedElementsWithElementsRepository)
    }

    private val elementViewModel: ElementViewModel by viewModels {
        ElementViewModelFactory((application as FuturisApplication).elementRepository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_new_project)

        new_project.setOnClickListener{
            //Creating a new project loads data from a project template JSON file
            val context = this
            var projectId: Long = 0
            val projectName = project_name.text.toString()
            lifecycleScope.launch {
                projectId = createProjectFromTemplate_vm(context,  projectName,
                    projectViewModel, composantViewModel, groupedElementsViewModel, materielViewModel, elementViewModel)
                val intent = Intent(context, ComposantActivity::class.java)
                intent.putExtra(EXTRA_PROJECT_SELECTED, projectId)
                intent.putExtra(EXTRA_NEW_PROJECT_CREATED, 1)
                context.startActivity(intent)
            }
        }
    }
}