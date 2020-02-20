package com.example.rabbittask.features.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import com.bumptech.glide.Glide
import com.example.rabbittask.R
import com.example.rabbittask.model.Attraction
import com.example.rabbittask.model.Event
import com.example.rabbittask.model.HotSpot
import kotlinx.android.synthetic.main.hot_spots_item.view.*

class HotSpotAdapter(private val interaction: Interaction? = null) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val DIFF_CALLBACK = object : DiffUtil.ItemCallback<HotSpot>() {

        override fun areItemsTheSame(oldItem: HotSpot, newItem: HotSpot): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: HotSpot, newItem: HotSpot): Boolean =
            oldItem.id == newItem.id

    }
    private val differ = AsyncListDiffer(this, DIFF_CALLBACK)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return HotSpotViewHolder(
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
            is HotSpotViewHolder -> {
                holder.bind(differ.currentList[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    fun submitList(list: List<HotSpot>) {
        differ.submitList(list)
    }

    class HotSpotViewHolder
    constructor(
        itemView: View,
        private val interaction: Interaction?
    ) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: HotSpot) = with(itemView) {
            itemView.setOnClickListener {
                interaction?.onItemSelected(adapterPosition, item)
            }
            itemView.tv_title.text = item.name
            if(item.photos.isNotEmpty()) Glide.with(itemView.context).load(item.photos[0]).placeholder(R.drawable.ic_empty).into(itemView.iv_hotspot_icon)
            if(item.categories.isNotEmpty()) tv_subtitle.text = item.categories[0].name
            else tv_subtitle.text = "subtitle"
        }
    }

    class EventsViewHolder
    constructor(
        itemView: View,
        private val interaction: Interaction?
    ) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: Event) = with(itemView) {
            itemView.setOnClickListener {
               // interaction?.onItemSelected(adapterPosition, item)
            }
            itemView.tv_title.text = item.name
         //   Glide.with(itemView.context).load(item.profile_photo).into(itemView.iv_hotspot_icon)
            //    tv_subtitle.tv_subtitle.text = item.categories[0].name

        }
    }

    class AttractionViewHolder
    constructor(
        itemView: View,
        private val interaction: Interaction?
    ) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: Attraction) = with(itemView) {
            itemView.setOnClickListener {
                // interaction?.onItemSelected(adapterPosition, item)
            }
            itemView.tv_title.text = item.name
           //    Glide.with(itemView.context).load(item.profile_photo).into(itemView.iv_hotspot_icon)
            //    tv_subtitle.tv_subtitle.text = item.categories[0].name

        }
    }

    interface Interaction {
        fun onItemSelected(position: Int, item: HotSpot)
    }
}
