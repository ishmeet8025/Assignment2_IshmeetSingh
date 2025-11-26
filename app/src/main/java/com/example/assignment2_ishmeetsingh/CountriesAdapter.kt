package com.example.assignment2_ishmeetsingh

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CountriesAdapter(
    private val items: MutableList<Country>,
    private val onClick: (Country, Int) -> Unit
) : RecyclerView.Adapter<CountriesAdapter.VH>() {

    inner class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.tvCountryName)
        init {
            itemView.setOnClickListener {
                val pos = bindingAdapterPosition
                if (pos != RecyclerView.NO_POSITION) onClick(items[pos], pos)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH =
        VH(LayoutInflater.from(parent.context).inflate(R.layout.item_country, parent, false))

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.tvName.text = items[position].name
    }

    override fun getItemCount(): Int = items.size

    fun removeAt(position: Int): Country {
        val removed = items.removeAt(position)
        notifyItemRemoved(position)
        return removed
    }

    fun addAt(position: Int, country: Country) {
        items.add(position, country)
        notifyItemInserted(position)
    }
}
