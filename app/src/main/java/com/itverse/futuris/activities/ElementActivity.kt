package com.itverse.futuris.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.itverse.futuris.adapters.ElementRecyclerAdapter
import com.itverse.futuris.COMPOSANT_NOT_SELECTED
import com.itverse.futuris.DataManager
import com.itverse.futuris.EXTRA_COMPOSANT_SELECTED
import com.itverse.futuris.R
import kotlinx.android.synthetic.main.activity_element.*

class ElementActivity : AppCompatActivity() {
    private var composantSelected = COMPOSANT_NOT_SELECTED

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_element)

        element_list.layoutManager = GridLayoutManager(this, 2)

        composantSelected = intent.getIntExtra(
            EXTRA_COMPOSANT_SELECTED,
            COMPOSANT_NOT_SELECTED
        )

        element_list.adapter =
            ElementRecyclerAdapter(
                this,
                DataManager.elements
            )
    }
}