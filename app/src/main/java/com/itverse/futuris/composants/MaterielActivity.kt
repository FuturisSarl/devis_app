package com.itverse.futuris.composants

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.itverse.futuris.*
import kotlinx.android.synthetic.main.activity_composant.*
import kotlinx.android.synthetic.main.activity_composants_materiel.*

class MaterielActivity : AppCompatActivity() {
    private  var composantSelected = COMPOSANT_NOT_SELECTED

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        composantSelected = intent.getIntExtra(EXTRA_COMPOSANT_SELECTED, COMPOSANT_NOT_SELECTED)
        println("Index of composant selected position: $composantSelected")
        var composants = DataManager.projects[0].composants[0]
        setContentView(R.layout.activity_composants_materiel)
        element_list.layoutManager = GridLayoutManager(this, 2)
        element_list.adapter = MaterielRecyclerAdapter(
            this, composants.materiels!!
        )
    }
}