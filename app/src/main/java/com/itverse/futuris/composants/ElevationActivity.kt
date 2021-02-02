package com.itverse.futuris.composants

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.itverse.futuris.DataManager
import com.itverse.futuris.R
import kotlinx.android.synthetic.main.activity_composants_elevation.*

class ElevationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_composants_elevation)
        list_grouped_elements.layoutManager = LinearLayoutManager(this)
        list_grouped_elements.adapter = GroupedElementsRecyclerAdapter(this, DataManager.projects[0].composants[2].elements)
    }
}