<<<<<<< HEAD:app/src/main/java/com/itverse/futuris/composants/MaterielRecyclerAdapter.kt
package com.itverse.futuris.composants
=======
package com.itverse.futuris.adapters
>>>>>>> 62051a5b04897ddf2c045b9a7c2350c87561d62a:app/src/main/java/com/itverse/futuris/adapters/ElementRecyclerAdapter.kt

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
<<<<<<< HEAD:app/src/main/java/com/itverse/futuris/composants/MaterielRecyclerAdapter.kt
import com.itverse.futuris.MaterielData
=======
import com.itverse.futuris.ElementData
>>>>>>> 62051a5b04897ddf2c045b9a7c2350c87561d62a:app/src/main/java/com/itverse/futuris/adapters/ElementRecyclerAdapter.kt
import com.itverse.futuris.R

class MaterielRecyclerAdapter(context: Context, private val materiels: ArrayList<MaterielData>):
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
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = layoutInflater.inflate(R.layout.item_materiel, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val element = materiels[position]
        holder.elementName.text = element.name
        holder.elementNumber.text = element.number.toString()
        holder.elementImg.setImageResource(element.imageResource)
        holder.elementPosition = position
    }

    override fun getItemCount() = materiels.size


}