package com.itverse.futuris

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_composant.*

class ComposantActivity : AppCompatActivity() {
    private  var projectSelected = PROJECT_NOT_SELECTED

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        projectSelected = intent.getIntExtra(EXTRA_PROJECT_SELECTED, PROJECT_NOT_SELECTED)
        println("Index of project selected position: $projectSelected")
        if (projectSelected != -1){
            setContentView(R.layout.activity_composant)
            composant_list.layoutManager = GridLayoutManager(this, 2)
            composant_list.adapter = ComposantRecyclerAdapter(this, DataManager.projects[projectSelected].composants)
        }
        else{

        }


    }
}