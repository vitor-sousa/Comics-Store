package com.vitorsousa.comicsstore

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.vitorsousa.comicsstore.placeholder.PlaceholderContent.PlaceholderItem
import com.vitorsousa.comicsstore.databinding.FragmentItemBinding


interface HQItemListener {
    fun onItemSelected(position: Int)
}

class MyhqRecyclerViewAdapter(
    private val values: List<PlaceholderItem>,
    private val listener: HQItemListener
) : RecyclerView.Adapter<MyhqRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.idView.text = item.id
        holder.contentView.text = item.content
        holder.view.setOnClickListener {
            listener.onItemSelected(position)
        }
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val view: View = binding.root
        val idView: TextView = binding.itemNumber
        val contentView: TextView = binding.content

        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }
    }

}