package com.micpol.norbsoft_recruitment_task.feature.home.list

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.micpol.norbsoft_recruitment_task.R
import com.micpol.norbsoft_recruitment_task.data.model.Channel
import kotlinx.android.synthetic.main.item_channel.view.*

class ChannelsAdapter(


) : RecyclerView.Adapter<ChannelsAdapter.ChannelViewHolder>() {

    private val data = mutableListOf<Channel>()

    fun submitList(items: List<Channel>) {
        data.clear()
        data.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChannelViewHolder {
        return ChannelViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_channel,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ChannelViewHolder, position: Int) {
        holder.bind(data[position])
    }

    class ChannelViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(channel: Channel) {
            setupVH(channel)
        }

        private fun setupVH(channel: Channel?) {
            channel?.snippet?.let {
                itemView.channelTitleACTV.text = it.title
                itemView.channelDescription.text = it.description
                it.thumbnails.high.let { thumb ->
                    Glide.with(itemView)
                        .load(thumb.url)
                        .into(itemView.thumbnailIV)
                } ?: Log.d("ChannelViewHolder", "setupVH: didn't work");
            }
        }

        fun clear() {
            setupVH(null)
        }
    }
}