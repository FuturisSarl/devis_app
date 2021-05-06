package com.itverse.futuris.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.itverse.futuris.*
import com.itverse.futuris.adapters.GroupedElementsRecyclerAdapter
import com.itverse.futuris.adapters.MaterielRecyclerAdapter
import com.itverse.futuris.adapters.ProjectRecyclerAdapter
import com.itverse.futuris.mViewModels.MaterielViewModel
import com.itverse.futuris.mViewModels.MaterielViewModelFactory
import com.itverse.futuris.mViewModels.ProjectViewModel
import com.itverse.futuris.mViewModels.ProjectViewModelFactory
import com.itverse.futuris.utils.*
import kotlinx.android.synthetic.main.activity_composants_materiel.*
import kotlinx.android.synthetic.main.activity_data_collection_form.*
import kotlinx.android.synthetic.main.content_activity_project.*


/**
 * This module implements a DataCollection activity that uses click to increment or decrement a given material.
 * Events are handled on the adapter: MaterielRecyclerAdapter
 */

class DataCollectionForm : AppCompatActivity() {
    private  var composantSelected = COMPOSANT_NOT_SELECTED
    private lateinit var composantName: String

    private val materielViewModel: MaterielViewModel by viewModels {
        MaterielViewModelFactory((application as FuturisApplication).materielRepository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        composantSelected = intent.getLongExtra(EXTRA_COMPOSANT_SELECTED, COMPOSANT_NOT_SELECTED)
        composantName = intent.getStringExtra(EXTRA_COMPOSANT_NAME)!!

        //TODO: The condition should be the composant name to be material?
        if (composantName == "Materiel"){
            //Is material
            setContentView(R.layout.activity_composants_materiel)
            val adapter = MaterielRecyclerAdapter(this)
            element_list.layoutManager = GridLayoutManager(this, 2)
            materielViewModel.allMateriels(composantSelected).observe(this){
                    materiels ->
                materiels.let { adapter.submitList(it) }
            }

            element_list.adapter = adapter

        }
        else{
            setContentView(R.layout.activity_data_collection_form)
            val adapter = GroupedElementsRecyclerAdapter(this)
            grouped_form.layoutManager = LinearLayoutManager(this)

            //TODO: setup viewModel here
            grouped_form.adapter = adapter

            action_save.setOnClickListener {
                //TODO: Save collected data from the Array to the DB
                println("Saved")
                }

        }

    }
}