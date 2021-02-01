package com.itverse.futuris.Composants

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.itverse.futuris.DataManager
import com.itverse.futuris.R
import kotlinx.android.synthetic.main.activity_composants_materiel.*

class MaterielActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_composants_materiel)

        element_list.layoutManager = GridLayoutManager(this, 2)

        element_list.adapter = MaterielRecyclerAdapter(this, DataManager.elements)
    }
}