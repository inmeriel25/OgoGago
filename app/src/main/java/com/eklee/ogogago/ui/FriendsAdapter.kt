package com.eklee.ogogago.ui

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.eklee.ogogago.R
import com.eklee.ogogago.models.Friend
import kotlinx.android.synthetic.main.friend_list_item.view.*

class FriendsAdapter: RecyclerView.Adapter<ViewHolder>() {
/*class FriendAdapter(private val items : ArrayList<Friend>) : RecyclerView.Adapter<ViewHolder>() {*/

    val items = arrayListOf(
        Friend("백예린", "여", "10000 원"),
        Friend("전정국", "남", "250000 원"),
        Friend("김태형", "남", "300000 원"),
        Friend("랩몬", "남", "10000 원"),
        Friend("양갱", "남", "250000 원"),
        Friend("댕", "남", "300000 원"),
        Friend("율무", "남", "10000 원"),
        Friend("미주", "남", "250000 원"),
        Friend("케이", "남", "300000 원"),
        Friend("크리스탈", "남", "300000 원"),
        Friend("설리", "남", "250000 원"),
        Friend("엠버", "남", "10000 원")
    )

    // Gets the number of animals in the list
    override fun getItemCount(): Int {
        return items.size
    }

    // Inflates the item views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.friend_list_item,
                parent,
                false
            )
        )
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