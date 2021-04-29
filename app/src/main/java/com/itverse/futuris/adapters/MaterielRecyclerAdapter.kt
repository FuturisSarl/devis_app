package com.itverse.futuris.adapters
import android.content.Context
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

import com.itverse.futuris.R
import com.itverse.futuris.data.entities.Materiel


/**
 * This module implements MaterielRecyclerAdapter which allows collecting data from clicking on the item to increment or decrement its quantity
 */

class MaterielRecyclerAdapter(val context: Context):
    ListAdapter<Materiel, MaterielRecyclerAdapter.ViewHolder>(MATERIEL_COMPATATOR) {

    private val layoutInflater = LayoutInflater.from(context)

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val elementImg: ImageView = itemView.findViewById(R.id.elementImg)
        val elementName: TextView = itemView.findViewById(R.id.elementName)
        val elementNumber: TextView = itemView.findViewById(R.id.elementNumber)
        var elementPosition: Int = 0

        init {
            itemView.setOnClickListener {
                //TODO: Increment number for this material. UI is listeninng to DB changes, so we shouldn't need to notifyDataSetChanges
                //materiels[elementPosition].number++
                notifyDataSetChanged()
            }
            //TODO: Review UX of this approach
            itemView.setOnLongClickListener {
                //TODO: Increment number for this material. UI is listeninng to DB changes, so we shouldn't need to notifyDataSetChanges
                //materiels[elementPosition].number--
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
        val element = getItem(position)
        val resources: Resources = context.resources
        val resourceId = resources.getIdentifier(element.imageResource, "drawable", context.packageName);
        holder.elementName.text = element.name
        holder.elementNumber.text = element.quantity.toString()
        holder.elementImg.setImageResource(resourceId)
        holder.elementPosition = position
    }

    companion object {
        private val MATERIEL_COMPATATOR = object : DiffUtil.ItemCallback<Materiel>() {
            override fun areItemsTheSame(oldItem: Materiel, newItem: Materiel): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Materiel, newItem: Materiel): Boolean {
                return oldItem.name == newItem.name
            }
        }
    }

}