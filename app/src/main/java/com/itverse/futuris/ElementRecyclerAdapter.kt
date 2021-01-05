package com.itverse.futuris

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ElementRecyclerAdapter(private val context: Context, private val elements: ArrayList<ElementData>):
    RecyclerView.Adapter<ElementRecyclerAdapter.ViewHolder>() {

    private val layoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = layoutInflater.inflate(R.layout.element_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val element = elements[position]
        holder.elementName.text = element.name
        holder.elementNumber.text = element.number.toString()
        holder.elementImg.setImageResource(element.imageResource)
        holder.elementPosition = position
    }

    override fun getItemCount() = elements.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val elementImg: ImageView = itemView.findViewById(R.id.elementImg)
        val elementName: TextView = itemView.findViewById(R.id.elementName)
        val elementNumber: TextView = itemView.findViewById(R.id.elementNumber)
        var elementPosition: Int = 0
        init {
            elementImg.setOnClickListener {
                elements[elementPosition].number++
                println("Element position: $elementPosition \n ${elements[elementPosition].number}")
                notifyDataSetChanged()
            }
        }
    }
}