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
import com.itverse.futuris.R
import com.itverse.futuris.activities.DataCollectionClick
import com.itverse.futuris.activities.DataCollectionForm

class ComposantRecyclerAdapter(private val context: Context, private val composants: ArrayList<ComposantData>):
    RecyclerView.Adapter<ComposantRecyclerAdapter.ViewHolder>() {

    private val layoutInflater = LayoutInflater.from(context)

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val composantImg: ImageView = itemView.findViewById(R.id.composantImg)
        val composantText: TextView = itemView.findViewById(R.id.composantText)
        var composantSelected = 0

        init {
            itemView.setOnClickListener{
                //We have 2 possible display: The form like activity and the click/touch to increment activity
                //TODO: Make these 2 options clear?
                var intent: Intent = when (composantSelected){
                    0 -> Intent(context, DataCollectionClick::class.java)
                    else -> {
                        Intent(context, DataCollectionForm::class.java)
                    }
                }
                context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = layoutInflater.inflate(R.layout.item_composant, parent,false)
        return  ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val composant = composants[position]
        holder.composantImg.setImageResource(composant.imageResource)
        holder.composantText.text = composant.name
        holder.composantSelected = position
    }

    override fun getItemCount() = composants.size

}
