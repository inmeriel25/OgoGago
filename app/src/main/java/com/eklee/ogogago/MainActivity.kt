package com.eklee.ogogago

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // Initializing an empty ArrayList to be filled with animals
    //val friends: ArrayList<Friend> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //임시로 사용할 데이터 (실제로는 대부분 DB에서 가져옴)
        val friendsList = arrayListOf(
            Friend("백예린","여","10000 원"),
            Friend("전정국","남","250000 원"),
            Friend("김태형","남","300000 원"),
            Friend("랩몬","남","10000 원"),
            Friend("양갱","남","250000 원"),
            Friend("댕","남","300000 원"),
            Friend("율무","남","10000 원"),
            Friend("미주","남","250000 원"),
            Friend("케이","남","300000 원"),
            Friend("크리스탈","남","300000 원"),
            Friend("설리","남","250000 원"),
            Friend("엠버","남","10000 원")
        )

        // Creates a vertical Layout Manager
        rv_friend_list.layoutManager = LinearLayoutManager(this)

        // You can use GridLayoutManager if you want multiple columns. Enter the number of columns as a parameter.
//        rv_animal_list.layoutManager = GridLayoutManager(this, 2)

        // Access the RecyclerView Adapter and load the data into it
        rv_friend_list.adapter = FriendAdapter(friendsList, this)



    }



}

