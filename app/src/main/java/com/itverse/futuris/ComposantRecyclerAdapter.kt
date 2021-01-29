package com.itverse.futuris

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ComposantRecyclerAdapter(private val context: Context, private val composants: ArrayList<ComposantData>):
    RecyclerView.Adapter<ComposantRecyclerAdapter.ViewHolder>() {

    private val layoutInflater = LayoutInflater.from(context)

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val composantImg: ImageView = itemView.findViewById(R.id.composantImg)
        val composantText: TextView = itemView.findViewById(R.id.composantText)
        var composantSelected = 0

        init {
            itemView.setOnClickListener{
                var intent: Intent

                when (composantSelected){
                    0 -> intent = Intent(context, MaterielActivity::class.java)
                    1 -> intent = Intent(context, FondationActivity::class.java)
                    2 -> intent = Intent(context, ElevationActivity::class.java)
                    //TODO: Implement all screens
                    //TODO: Handle error on unexpected composantSelected value
                    else -> {
                        intent  = Intent(context, MaterielActivity::class.java)
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
        val keys = composants
        val composant = composants[position]
        holder.composantImg.setImageResource(composant.imageResource)
        holder.composantText.text = composant.name
        holder.composantSelected = position

    }

    override fun getItemCount() = composants.size

}
