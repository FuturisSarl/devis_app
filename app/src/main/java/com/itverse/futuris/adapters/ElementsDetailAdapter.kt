package com.itverse.futuris.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.widget.doAfterTextChanged
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText
import com.itverse.futuris.ElementsDetail
import com.itverse.futuris.R

class ElementsDetailAdapter(val context: Context, private var details: ArrayList<ElementsDetail>): RecyclerView.Adapter<ElementsDetailAdapter.ViewHolder>() {
    private val layoutInflater = LayoutInflater.from(context)

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val itemDetailLabel: TextView = itemView.findViewById(R.id.item_detail_label)
        var itemDetailInput: TextInputEditText = itemView.findViewById(R.id.item_detail_input)
        var elementPosition: Int = 0

        init {
            itemDetailInput.doAfterTextChanged {
                println("Data is: ${details[elementPosition].value} | Text: ${this.itemDetailInput.text?.toString()}")
                if (itemDetailInput.text.toString() != "")
                    details[elementPosition].value = this.itemDetailInput.text.toString().toInt()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = layoutInflater.inflate(R.layout.item_element_details, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val detail = details[position]
        holder.itemDetailLabel.text = detail.name
        if (detail.value != null)
            holder.itemDetailInput.setText(detail.value.toString())
        holder.elementPosition = position
    }

    override fun getItemCount(): Int {
        return  details.size
    }

}