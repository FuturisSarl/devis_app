package com.itverse.futuris.composants

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.itverse.futuris.DataManager
import com.itverse.futuris.R
import kotlinx.android.synthetic.main.activity_composants_elevation.*

class PlomberieActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_composants_plomberie)
        list_grouped_elements.layoutManager = LinearLayoutManager(this)
        list_grouped_elements.adapter = GroupedElementsRecyclerAdapter(this, DataManager.projects[0].composants[7].elements)

    }
}