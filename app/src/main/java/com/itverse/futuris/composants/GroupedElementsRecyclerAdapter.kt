package com.itverse.futuris.composants

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.itverse.futuris.GroupedElementsData
import com.itverse.futuris.R

class GroupedElementsRecyclerAdapter(
    var context: Context, private  val elements: ArrayList<GroupedElementsData>?): RecyclerView.Adapter<GroupedElementsRecyclerAdapter.ViewHolder>() {

    private val layoutInflater = LayoutInflater.from(context)

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val groupedElementTitle: TextView = itemView.findViewById(R.id.grouped_element_title)
        val groupedElementsList: RecyclerView = itemView.findViewById(R.id.grouped_elements_list)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupedElementsRecyclerAdapter.ViewHolder {
        val itemView = layoutInflater.inflate(R.layout.item_grouped_elements, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: GroupedElementsRecyclerAdapter.ViewHolder, position: Int) {
        val element = elements?.get(position)
        holder.groupedElementTitle.text = element!!.title
        holder.groupedElementsList.layoutManager = LinearLayoutManager(context)
        holder.groupedElementsList.adapter = ElementsDetailAdapter(context, element.details)

    }

    override fun getItemCount(): Int {
        return elements?.size ?: 0
    }

}