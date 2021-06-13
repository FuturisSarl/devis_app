package com.itverse.futuris.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.itverse.futuris.*
import com.itverse.futuris.adapters.GroupedElementsRecyclerAdapter
import com.itverse.futuris.adapters.MaterielRecyclerAdapter
import com.itverse.futuris.mViewModels.*
import com.itverse.futuris.utils.*
import kotlinx.android.synthetic.main.activity_composants_materiel.*
import kotlinx.android.synthetic.main.activity_data_collection_form.*


/**
 * This module implements a DataCollection activity that uses click to increment or decrement a given material.
 * Events are handled on the adapter: MaterielRecyclerAdapter
 */

class DataCollectionForm : AppCompatActivity() {
    private  var composantSelected = COMPOSANT_NOT_SELECTED
    private lateinit var composantName: String
    // Hashmap <ElementId, Element Quantity value>
    private val inMemoryElementChanges: HashMap<Long, Int> = HashMap()

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
        composantSelected = intent.getLongExtra(EXTRA_COMPOSANT_SELECTED, COMPOSANT_NOT_SELECTED)
        composantName = intent.getStringExtra(EXTRA_COMPOSANT_NAME)!!

        //TODO: The condition should be the composant name to be material?
        // Material has a different UI to allow faster input of data
        if (composantName == "Materiel"){
            setContentView(R.layout.activity_composants_materiel)
            val adapter = MaterielRecyclerAdapter(this, materielViewModel)
            element_list.layoutManager = GridLayoutManager(this, 2)
            materielViewModel.allMaterielsFrom(composantSelected).observe(this){
                    it.let { adapter.submitList(it) }
            }

            element_list.adapter = adapter

        }
        else{
            setContentView(R.layout.activity_data_collection_form)
            val adapter = GroupedElementsRecyclerAdapter(this, inMemoryElementChanges)
            grouped_form.layoutManager = LinearLayoutManager(this)

            groupedElementsViewModel.allGroupedElementsFrom(composantSelected).observe(this){
                element ->
                element.let { adapter.submitList(it) }
            }

            grouped_form.adapter = adapter
            action_save.setOnClickListener {
                /*TODO:
                       1. Get composant that have changed from inMemoryElementChanges
                       2. Update the inputs that changed on the database
                       3. Notify changes
                     */
                inMemoryElementChanges.entries.forEach {
                    if (it.key != 0.toLong())
                        elementViewModel.update(it.key, it.value)

                    Log.i("save", "inMemoryComposantChanges: ${it.key} : ${it.value}")
                }

                }
        }

    }
}