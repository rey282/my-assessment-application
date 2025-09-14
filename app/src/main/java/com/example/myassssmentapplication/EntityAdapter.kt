package com.example.myassssmentapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.JsonObject

class EntityAdapter(
    private val entities: List<JsonObject>,
    private val onClick: (JsonObject) -> Unit
) : RecyclerView.Adapter<EntityAdapter.EntityViewHolder>() {

    inner class EntityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvLine1: TextView = itemView.findViewById(R.id.tvItemName)
        val tvLine2: TextView = itemView.findViewById(R.id.tvMaterial)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntityViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_entity, parent, false)
        return EntityViewHolder(view)
    }

    override fun onBindViewHolder(holder: EntityViewHolder, position: Int) {
        val entity = entities[position]

        val keys = entity.keySet().filter { it != "description" }
        val firstKey = keys.getOrNull(0)
        val secondKey = keys.getOrNull(1)

        holder.tvLine1.text = "${firstKey ?: ""}: ${entity[firstKey]?.asString ?: ""}"
        holder.tvLine2.text = "${secondKey ?: ""}: ${entity[secondKey]?.asString ?: ""}"

        holder.itemView.setOnClickListener { onClick(entity) }
    }

    override fun getItemCount() = entities.size
}
