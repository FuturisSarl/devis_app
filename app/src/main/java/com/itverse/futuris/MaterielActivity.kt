package com.itverse.futuris

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_element.*

class MaterielActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_element)

        element_list.layoutManager = GridLayoutManager(this, 2)

        element_list.adapter = MaterielRecyclerAdapter(this, DataManager.elements)
    }
}