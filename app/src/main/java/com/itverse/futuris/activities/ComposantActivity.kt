package com.itverse.futuris.activities

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.lifecycle.asLiveData
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.itverse.futuris.*
import com.itverse.futuris.adapters.ComposantRecyclerAdapter
import com.itverse.futuris.data.entities.GroupedElements
import com.itverse.futuris.data.entities.Materiel
import com.itverse.futuris.data.entities.relations.GroupedElementsWithElements
import com.itverse.futuris.mViewModels.*
import com.itverse.futuris.utils.EXTRA_PROJECT_SELECTED
import com.itverse.futuris.utils.PROJECT_NOT_SELECTED
import com.itverse.futuris.utils.generateExcelFileTest
import kotlinx.android.synthetic.main.activity_composant.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch


class ComposantActivity : AppCompatActivity() {
    private  var projectSelected = PROJECT_NOT_SELECTED

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

    private fun export() {
        var context = this
        lifecycleScope.launch {
            val project = projectViewModel.get(projectSelected)
            Log.i("export", "Exporting project: $project")

            val composants = composantViewModel.allComposantsFrom_(project.id)
            val groupedElements: ArrayList<List<GroupedElementsWithElements>> = ArrayList()
            var groupedElement: List<GroupedElementsWithElements>
            var materiel: List<Materiel> = listOf()
            composants.forEach {
                groupedElement = groupedElementsViewModel.allGroupedElementsFrom_(it.id)
                if (groupedElement.isNotEmpty())
                    groupedElements.add(groupedElement)
                else
                    materiel = materielViewModel.allMaterielsFrom_(it.id)
               }
            generateExcelFileTest(
                context, project, composants, groupedElements, materiel
            )
            Toast.makeText(
                context, "Exportation terminé avec success",
                Toast.LENGTH_SHORT
            ).show()

        }
    }

    private val requestPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()
        ) { isGranted: Boolean ->
            if (isGranted) {
                    export()
                }
            else {
                Toast.makeText(this, "Write access to storage is required to generate the Excel file",
                    Toast.LENGTH_SHORT).show()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        //setSupportActionBar(findViewById(R.id.composant_toolbar))
        projectSelected = intent.getLongExtra(
            EXTRA_PROJECT_SELECTED,
            PROJECT_NOT_SELECTED
        )

        if (!projectSelected.equals(-1)){
            setContentView(R.layout.activity_composant)
            val adapter =  ComposantRecyclerAdapter(this)

            composant_list.layoutManager = GridLayoutManager(this, 2)
            var context = this
            lifecycleScope.launch {
                composantViewModel.allComposantsFrom(projectSelected).asLiveData().observe(context) { composants ->
                    // Update the cached copy of the project in the adapter.
                    composants.let { adapter.submitList(it) }
                }
            }

            composant_list.adapter = adapter

        }
        else{
            //TODO: Display something when no project is found
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.composants, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_save -> getStorageWriteAccess()
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun getStorageWriteAccess(): Boolean {
        when {
            ContextCompat.checkSelfPermission(
                this,
                android.Manifest.permission.WRITE_EXTERNAL_STORAGE
            ) == PackageManager.PERMISSION_GRANTED -> {

                Log.i("permission", "Already has permission!")
                export()
            }
            shouldShowRequestPermissionRationale(android.Manifest.permission.WRITE_EXTERNAL_STORAGE) -> {
                Log.i("permissions","Running shouldShowRequestPermissionRationale condition")
            }
            else -> {
                // You can directly ask for the permission.
                // The registered ActivityResultCallback gets the result of this request.
                requestPermissionLauncher.launch(
                    android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
            }
        }
    return true
    }
}