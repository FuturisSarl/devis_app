package com.itverse.futuris.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.itverse.futuris.ComposantData
import com.itverse.futuris.EXTRA_COMPOSANT_SELECTED
import com.itverse.futuris.activities.ElementActivity
import com.itverse.futuris.R

class ComposantRecyclerAdapter(private val context: Context, private val composants: ArrayList<ComposantData>):
    RecyclerView.Adapter<ComposantRecyclerAdapter.ViewHolder>() {

    private val layoutInflater = LayoutInflater.from(context)

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val composantImg: ImageView = itemView.findViewById(R.id.composantImg)
        val composantText: TextView = itemView.findViewById(R.id.composantText)
        var composantSelected = 0

        init {
            itemView.setOnClickListener{
                val intent = Intent(context, ElementActivity::class.java)
                intent.putExtra(EXTRA_COMPOSANT_SELECTED, composantSelected)
                context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = layoutInflater.inflate(R.layout.item_composant, parent,false)
        return  ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val keys = composants
        val composant = composants[position]
        holder.composantImg.setImageResource(composant.imageResource)
        holder.composantText.text = composant.name
        holder.composantSelected = position

    }

    override fun getItemCount() = composants.size

}
