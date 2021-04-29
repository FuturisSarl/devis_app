package com.itverse.futuris.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.widget.doAfterTextChanged
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.itverse.futuris.R
import com.itverse.futuris.data.entities.Element
import com.itverse.futuris.data.entities.Project

class ElementsDetailAdapter(val context: Context):
    ListAdapter< Element,ElementsDetailAdapter.ViewHolder>(ELEMENT_COMPARATOR) {
    private val layoutInflater = LayoutInflater.from(context)

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        val itemDetailLabel: TextView = itemView.findViewById(R.id.item_detail_label)
        var itemDetailInput: AppCompatEditText = itemView.findViewById(R.id.item_detail_input)
        var elementPosition: Int = 0

        init {
            val item = getItem(elementPosition)
            itemDetailInput.doAfterTextChanged {
                println("Data is: ${item.value} | Text: ${this.itemDetailInput.text}")
                item.value = this.itemDetailInput.text.toString().toInt().toString()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = layoutInflater.inflate(R.layout.item_element_details, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val detail = getItem(position)
        holder.itemDetailLabel.text = detail.name
        if (detail.value != null)
            holder.itemDetailInput.setText(detail.value.toString())
        holder.elementPosition = position
    }

    companion object {
        private val ELEMENT_COMPARATOR = object : DiffUtil.ItemCallback<Element>() {
            override fun areItemsTheSame(oldItem: Element, newItem: Element): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Element, newItem: Element): Boolean {
                return oldItem.name == newItem.name
            }
        }
    }

}