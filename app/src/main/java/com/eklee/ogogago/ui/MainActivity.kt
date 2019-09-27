package com.eklee.ogogago.ui

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.Fragment
import com.eklee.ogogago.*
import com.eklee.ogogago.ui.fragments.FriendsFragment
import com.eklee.ogogago.ui.fragments.MoreFragment
import com.eklee.ogogago.ui.fragments.NewAddFragment
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T



class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<View>(R.id.bottom_navigation) as BottomNavigationView
        bottomNavigationView.setOnNavigationItemSelectedListener(this)

        replaceFragment(FriendsFragment())
    }

    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        when(p0.itemId){
            R.id.nav_friend ->{
                replaceFragment(FriendsFragment())
                return true
            }
            R.id.nav_new_add -> {
                replaceFragment(NewAddFragment())
                return true
            }
            R.id.nav_more -> {
                replaceFragment(MoreFragment())
                return true
            }
        }
        return false
    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
    /*    fragmentTransaction.replace(R.id.nav_host_fragment, fragment)*/
        fragmentTransaction.replace(R.id.fragment_container, fragment)
        fragmentTransaction.commit()
    }

}

