package com.itverse.futuris.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.itverse.futuris.*
import com.itverse.futuris.adapters.GroupedElementsRecyclerAdapter
import com.itverse.futuris.adapters.MaterielRecyclerAdapter
import kotlinx.android.synthetic.main.activity_composants_materiel.*
import kotlinx.android.synthetic.main.activity_data_collection_form.*


/**
 * This module implements a DataCollection activity that uses click to increment or decrement a given material.
 * Events are handled on the adapter: MaterielRecyclerAdapter
 */

class DataCollectionForm : AppCompatActivity() {
    private var composantSelected = COMPOSANT_NOT_SELECTED
    private var projectSelected = PROJECT_NOT_SELECTED

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        composantSelected = intent.getIntExtra(EXTRA_COMPOSANT_SELECTED, COMPOSANT_NOT_SELECTED)

        projectSelected = intent.getIntExtra(EXTRA_PROJECT_SELECTED, PROJECT_NOT_SELECTED)

        //TODO: The condition should be the composant name to be material?
        if (composantSelected == 0) {
            //Is material
            setContentView(R.layout.activity_composants_materiel)
            element_list.layoutManager = GridLayoutManager(this, 2)
            println(
                "Material selected: ${DataManager.projects[projectSelected].composants[composantSelected]}"
            )
            element_list.adapter = MaterielRecyclerAdapter(
                this,
                DataManager.projects[projectSelected].composants[composantSelected].materials!!
            )
        } else {
            setContentView(R.layout.activity_data_collection_form)
            grouped_form.layoutManager = LinearLayoutManager(this)
            val adapter = GroupedElementsRecyclerAdapter(
                this,
                DataManager.projects[projectSelected].composants[composantSelected].groupedElements
            )
            grouped_form.adapter = adapter

            action_save.setOnClickListener {
                //TODO: Save collected data from the Array to the DB
                Toast.makeText(this, "Save", Toast.LENGTH_SHORT).show()
                finish()
            }
            /*while (items!=0){
                (grouped_form.adapter as GroupedElementsRecyclerAdapter).item
                items--
            }*/
        }
    }
}