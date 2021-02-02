package com.itverse.futuris.composants

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText
import com.itverse.futuris.ElementsDetailData
import com.itverse.futuris.R

class ElementsDetailAdapter(val context: Context, private var details: ArrayList<ElementsDetailData>): RecyclerView.Adapter<ElementsDetailAdapter.ViewHolder>() {
    private val layoutInflater = LayoutInflater.from(context)

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val itemDetailLabel: TextView = itemView.findViewById(R.id.item_detail_label)
        //val itemDetailInput: TextInputEditText = itemView.findViewById(R.id.item_detail_input)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = layoutInflater.inflate(R.layout.item_element_details, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val detail = details[position]
        holder.itemDetailLabel.text = detail.name
    }

    override fun getItemCount(): Int {
        return  details.size
    }

}