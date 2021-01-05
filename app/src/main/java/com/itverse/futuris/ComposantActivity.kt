package com.itverse.futuris

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_composant.*

class ComposantActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_composant)

        composant_list.layoutManager = GridLayoutManager(this, 2)
        composant_list.adapter = ComposantRecyclerAdapter(this, DataManager.composants)

    }
}