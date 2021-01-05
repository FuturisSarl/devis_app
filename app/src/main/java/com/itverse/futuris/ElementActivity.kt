package com.itverse.futuris

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_element.*

class ElementActivity : AppCompatActivity() {
    private var composantSelected = COMPOSANT_NOT_SELECTED

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_element)

        //composant_list.layoutManager = LinearLayoutManager(this)
        element_list.layoutManager = GridLayoutManager(this, 2)
        element_list.adapter = ElementRecyclerAdapter(this, DataManager.elements)

        composantSelected = intent.getIntExtra(EXTRA_COMPOSANT_SELECTED, COMPOSANT_NOT_SELECTED)
        //This activity should always have EXTRA_COMPOSANT_SELECTED to show the right elements

    }
}