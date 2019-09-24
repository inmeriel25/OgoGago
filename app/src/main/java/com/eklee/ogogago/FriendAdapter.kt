package com.eklee.ogogago

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.friend_list_item.view.*
import java.util.*

class FriendAdapter(private val items : ArrayList<Friend>, private val context: Context) : RecyclerView.Adapter<ViewHolder>() {

    // Gets the number of animals in the list
    override fun getItemCount(): Int {
        return items.size
    }

    // Inflates the item views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.friend_list_item, parent, false))
    }

    // Binds each animal in the ArrayList to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder?.tvFrindName?.text = items.get(position).name
        //holder?.tvFrindSex?.text = items.get(position).sex
        holder?.tvMoney?.text = items.get(position).money
    }
}


class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    val tvFrindName = view.tv_friend_name
    //val tvFrindSex = view.tv_friend_sex
    val tvMoney = view.tv_money
}