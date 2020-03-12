package com.example.ktmovies.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ktmovies.R
import com.example.ktmovies.domain.BotMessage
import kotlinx.android.synthetic.main.item_bot_message.view.*
import kotlinx.android.synthetic.main.item_user_message.view.*
import java.util.*

/**
 * Created by danilorangel on 15/07/18.
 */
class BotAdapter(private val items: LinkedList<BotMessage> = LinkedList()) : RecyclerView.Adapter<BotAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder =
            ItemViewHolder(LayoutInflater.from(parent.context).inflate(when (viewType) {
                0 -> R.layout.item_bot_message
                1 -> R.layout.item_user_message
                else -> 0
            }, parent, false))

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        with(holder.itemView) {
            if (holder.itemViewType == 0) {
                txtMessageBot.text = items[position].message
            } else {
                txtMessageUser.text = items[position].message
            }
        }
    }

    override fun getItemViewType(position: Int): Int = if (items[position].isBot) 0 else 1

    fun addMessage(message: BotMessage) {
        items.add(message)
        notifyDataSetChanged()
    }

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view)
}