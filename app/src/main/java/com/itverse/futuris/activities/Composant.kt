package com.itverse.futuris.activities

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.itverse.futuris.*
import com.itverse.futuris.adapters.ComposantRecyclerAdapter
import com.itverse.futuris.utils.generateExcelFileTest
import kotlinx.android.synthetic.main.activity_composant.*


class Composant : AppCompatActivity() {
    private  var projectSelected = PROJECT_NOT_SELECTED
    private val requestPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()
        ) { isGranted: Boolean ->
            if (isGranted) {
                //TODO: Clean up the code  :)
                generateExcelFileTest(this, projectSelected)
                Toast.makeText(this, "Exportation terminé avec success",
                    Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Write access to storage is required to generate the Excel file",
                    Toast.LENGTH_SHORT).show()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        System.setProperty("org.apache.poi.javax.xml.stream.XMLOutputFactory", "com.fasterxml.aalto.stax.OutputFactoryImpl");
        System.setProperty("org.apache.poi.javax.xml.stream.XMLEventFactory", "com.fasterxml.aalto.stax.EventFactoryImpl");
        
        //setSupportActionBar(findViewById(R.id.composant_toolbar))
        projectSelected = intent.getIntExtra(
            EXTRA_PROJECT_SELECTED,
            PROJECT_NOT_SELECTED
        )
        println("Index of project selected position: $projectSelected")
        if (projectSelected != -1){
            setContentView(R.layout.activity_composant)
            composant_list.layoutManager = GridLayoutManager(this, 2)

            composant_list.adapter =
                ComposantRecyclerAdapter(
                    this,
                    DataManager.projects[projectSelected].composants,
                    projectSelected
                )
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
                println("Already has permission!")
                generateExcelFileTest(this, projectSelected)
                Toast.makeText(this, "Exportation terminé avec success",
                    Toast.LENGTH_SHORT).show()
            }
            shouldShowRequestPermissionRationale(android.Manifest.permission.WRITE_EXTERNAL_STORAGE) -> {
                println("Running shouldShowRequestPermissionRationale condition")
            }
            else -> {
                // You can directly ask for the permission.
                // The registered ActivityResultCallback gets the result of this request.
                requestPermissionLauncher.launch(
                    android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
            }
        }
    return true;
    }
}