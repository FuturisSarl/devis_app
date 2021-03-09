package com.itverse.futuris.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.itverse.futuris.activities.Composant
import com.itverse.futuris.EXTRA_PROJECT_SELECTED
import com.itverse.futuris.ProjectData
import com.itverse.futuris.R

class ProjectRecyclerAdapter(val context: Context, private val projects: ArrayList<ProjectData>):
    RecyclerView.Adapter<ProjectRecyclerAdapter.ViewHolder>() {

    private val layoutInflater = LayoutInflater.from(context)

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val projectTitle: TextView = itemView.findViewById(R.id.projectTitle)
        val projectImage: ImageView = itemView.findViewById(R.id.projectImage)
        var projectPosition: Int = 0
        init {
            itemView.setOnClickListener {
                val intent = Intent(context, Composant::class.java)
                intent.putExtra(EXTRA_PROJECT_SELECTED, projectPosition)
                context.startActivity(intent)
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = layoutInflater.inflate(R.layout.item_project, parent,false)
        return  ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val project = projects[position]
        holder.projectTitle.text = project.name
        holder.projectImage.setImageResource(R.drawable.ic_project)
        holder.projectPosition = position
    }

    override fun getItemCount(): Int {
        return projects.size
    }
}