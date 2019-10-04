package com.eklee.ogogago.ui.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import com.eklee.ogogago.R
import com.eklee.ogogago.ui.FriendsAdapter
import kotlinx.android.synthetic.main.fragment_friends.*
import kotlinx.android.synthetic.main.fragment_friends.rv_friend_list

class FriendsFragment : Fragment() {

    companion object {
        fun newInstance() = FriendsFragment()
    }

    // 대량 리스트일 때 필요함. dependency 추가도 필요
    // 참고: https://developer.android.com/topic/libraries/architecture/viewmodel
//    private lateinit var viewModel: FriendsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_friends, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProviders.of(this).get(FriendsViewModel::class.java)

        refreshLayout.setOnRefreshListener {
            fetchFriends()
        }

        fetchFriends()
    }

    private fun fetchFriends(){
        refreshLayout.isRefreshing = false//db연동 후에 true
        showFriends()
        //db 불러오기
    }


    private fun showFriends(){
        rv_friend_list.layoutManager = LinearLayoutManager(activity)
        // You can use GridLayoutManager if you want multiple columns. Enter the number of columns as a parameter.
//        rv_animal_list.layoutManager = GridLayoutManager(this, 2)
        rv_friend_list.adapter = FriendsAdapter()
    }

}
