package com.itverse.futuris.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.itverse.futuris.activities.ComposantActivity
import com.itverse.futuris.R
import com.itverse.futuris.data.entities.Project
import com.itverse.futuris.utils.EXTRA_PROJECT_SELECTED


class ProjectRecyclerAdapter(val context: Context):
    ListAdapter<Project, ProjectRecyclerAdapter.ViewHolder>(PROJECT_COMPARATOR) {

    private val layoutInflater = LayoutInflater.from(context)

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val projectTitle: TextView = itemView.findViewById(R.id.projectTitle)
        val projectImage: ImageView = itemView.findViewById(R.id.projectImage)
        var projectPosition: Int = 0
        init {
            itemView.setOnClickListener {
                val intent = Intent(context, ComposantActivity::class.java)
                println("Project Selected: $projectPosition")
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
        val project = getItem(position)
        holder.projectTitle.text = project.name
        holder.projectImage.setImageResource(R.drawable.ic_project)
        holder.projectPosition = position
    }

    companion object {
        private val PROJECT_COMPARATOR = object : DiffUtil.ItemCallback<Project>() {
            override fun areItemsTheSame(oldItem: Project, newItem: Project): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Project, newItem: Project): Boolean {
                return oldItem.name == newItem.name
            }
        }
    }
}
