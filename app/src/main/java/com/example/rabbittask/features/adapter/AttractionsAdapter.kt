package com.example.rabbittask.features.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rabbittask.R
import com.example.rabbittask.model.Attraction
import kotlinx.android.synthetic.main.hot_spots_item.view.*

class AttractionsAdapter(private val interaction: Interaction? = null) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Attraction>() {

        override fun areItemsTheSame(oldItem: Attraction, newItem: Attraction): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Attraction, newItem: Attraction): Boolean =
            oldItem.id == newItem.id

    }
    private val differ = AsyncListDiffer(this, DIFF_CALLBACK)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return AttractionViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.hot_spots_item,
                parent,
                false
            ),
            interaction
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is AttractionViewHolder -> {
                holder.bind(differ.currentList[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    fun submitList(list: List<Attraction>) {
        differ.submitList(list)
    }

    class AttractionViewHolder
    constructor(
        itemView: View,
        private val interaction: Interaction?
    ) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: Attraction) = with(itemView) {
            itemView.setOnClickListener {
                interaction?.onItemSelected(adapterPosition, item)
            }
            itemView.tv_title.text = item.name
            Glide.with(itemView.context).load(R.drawable.bellman_bottom_icon)
                .placeholder(R.drawable.bellman_bottom_icon).into(itemView.iv_hotspot_icon)
            //    tv_subtitle.tv_subtitle.text = item.categories[0].name

        }
    }


    interface Interaction {
        fun onItemSelected(position: Int, item: Attraction)
    }
}