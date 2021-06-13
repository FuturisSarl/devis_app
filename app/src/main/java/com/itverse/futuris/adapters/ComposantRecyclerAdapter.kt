package com.itverse.futuris.adapters

import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.ListAdapter
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.itverse.futuris.R
import com.itverse.futuris.activities.DataCollectionForm
import com.itverse.futuris.data.entities.Composant
import com.itverse.futuris.utils.EXTRA_COMPOSANT_NAME
import com.itverse.futuris.utils.EXTRA_COMPOSANT_SELECTED

class ComposantRecyclerAdapter(val context: Context):
    ListAdapter<Composant, ComposantRecyclerAdapter.ViewHolder>(COMPOSANT_COMPARATOR) {

    private val layoutInflater = LayoutInflater.from(context)

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val composantImg: ImageView = itemView.findViewById(R.id.composantImg)
        val composantText: TextView = itemView.findViewById(R.id.composantText)
        var composantSelected: Long = 0

        init {
            itemView.setOnClickListener{
                val intent = Intent(context, DataCollectionForm::class.java)
                intent.putExtra(EXTRA_COMPOSANT_SELECTED, composantSelected)
                intent.putExtra(EXTRA_COMPOSANT_NAME, composantText.text)
                context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = layoutInflater.inflate(R.layout.item_composant, parent,false)
        return  ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val composant = getItem(position)
        val resources: Resources = context.resources
        val resourceId = resources.getIdentifier(composant.imageResource, "drawable", context.packageName)
        holder.composantImg.setImageResource(resourceId)
        holder.composantText.text = composant.name
        holder.composantSelected = composant.id
    }

    companion object {
        private val COMPOSANT_COMPARATOR = object : DiffUtil.ItemCallback<Composant>() {
            override fun areItemsTheSame(oldItem: Composant, newItem: Composant): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Composant, newItem: Composant): Boolean {
                return oldItem.name == newItem.name
            }
        }
    }
}
