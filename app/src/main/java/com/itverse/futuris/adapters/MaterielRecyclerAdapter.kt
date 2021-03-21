package com.itverse.futuris.adapters
import android.content.Context
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.itverse.futuris.DataManager
import com.itverse.futuris.Materiel

import com.itverse.futuris.R

/**
 * This module implements MaterielRecyclerAdapter which allows collecting data from clicking on the item to increment or decrement its quantity
 */

class MaterielRecyclerAdapter(val context: Context, private val materiels: ArrayList<Materiel>):
    RecyclerView.Adapter<MaterielRecyclerAdapter.ViewHolder>() {

    private val layoutInflater = LayoutInflater.from(context)

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val elementImg: ImageView = itemView.findViewById(R.id.elementImg)
        val elementName: TextView = itemView.findViewById(R.id.elementName)
        val elementNumber: TextView = itemView.findViewById(R.id.elementNumber)
        var elementPosition: Int = 0

        init {
            itemView.setOnClickListener {
                materiels[elementPosition].number++
                notifyDataSetChanged()
            }
            //TODO: Review UX of this approach
            itemView.setOnLongClickListener {
                materiels[elementPosition].number--
                notifyDataSetChanged()
                return@setOnLongClickListener true
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = layoutInflater.inflate(R.layout.item_materiel, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val element = materiels[position]
        val resources: Resources = context.resources
        val resourceId = resources.getIdentifier(element.imageResource, "drawable", context.packageName);
        holder.elementName.text = element.name
        holder.elementNumber.text = element.number.toString()
        holder.elementImg.setImageResource(resourceId)
        holder.elementPosition = position
    }

    override fun getItemCount() = materiels.size


}