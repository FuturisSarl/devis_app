package com.itverse.futuris

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.itverse.futuris.composants.*

class ComposantRecyclerAdapter(private val context: Context, private val composants: ArrayList<ComposantData>):
    RecyclerView.Adapter<ComposantRecyclerAdapter.ViewHolder>() {

    private val layoutInflater = LayoutInflater.from(context)

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val composantImg: ImageView = itemView.findViewById(R.id.composantImg)
        val composantText: TextView = itemView.findViewById(R.id.composantText)
        var composantSelected = 0

        init {
            itemView.setOnClickListener{

                var intent: Intent = when (composantSelected){
                    0 -> Intent(context, MaterielActivity::class.java)
                    1 -> Intent(context, FondationActivity::class.java)
                    2 -> Intent(context, ElevationActivity::class.java)
                    3 -> Intent(context, ToitureActivity::class.java)
                    4 -> Intent(context, FinitionActivity::class.java)
                    5 -> Intent(context, ElectriciteActivity::class.java)
                    6 -> Intent(context, MenuiserieActivity::class.java)
                    7 -> Intent(context, PlomberieActivity::class.java)
                    else -> {
                        //TODO: raise Error?
                        Intent(context, MaterielActivity::class.java)
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
