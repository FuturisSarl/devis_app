package com.itverse.futuris.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.itverse.futuris.R
import com.itverse.futuris.data.entities.GroupedElements
import com.itverse.futuris.data.entities.relations.GroupedElementsWithElements

/**
 *This module implements GroupedElementsRecyclerAdapter which allows displaying grouped data input
 */
class GroupedElementsRecyclerAdapter(var context: Context):
    ListAdapter<GroupedElementsWithElements, GroupedElementsRecyclerAdapter.ViewHolder>(ELEMENT_COMPARATOR) {

    private val layoutInflater = LayoutInflater.from(context)

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val groupedElementTitle: TextView = itemView.findViewById(R.id.grouped_element_title)
        val groupedElementsList: RecyclerView = itemView.findViewById(R.id.grouped_elements_list)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = layoutInflater.inflate(R.layout.item_grouped_elements, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.groupedElementTitle.text = item.groupedElement.name
        holder.groupedElementsList.layoutManager = LinearLayoutManager(context)
        //TODO: Link to live data for Elements
        holder.groupedElementsList.adapter = ElementsDetailAdapter(context, item.elements)
    }


    companion object {
        private val ELEMENT_COMPARATOR = object : DiffUtil.ItemCallback<GroupedElementsWithElements>() {
            override fun areItemsTheSame(oldItem: GroupedElementsWithElements, newItem: GroupedElementsWithElements): Boolean {
                return oldItem.groupedElement.id == newItem.groupedElement.id
            }

            override fun areContentsTheSame(oldItem: GroupedElementsWithElements, newItem: GroupedElementsWithElements): Boolean {
                return oldItem.groupedElement.name == newItem.groupedElement.name
            }
        }
    }
}