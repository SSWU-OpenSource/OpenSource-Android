package com.subeenie.opensource_android.presentation.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.subeenie.opensource_android.R
import com.subeenie.opensource_android.databinding.ActivityHomeBinding
import com.subeenie.opensource_android.presentation.mypage.MypageFragment
import com.subeenie.opensource_android.presentation.search.SearchFragment

class HomeActivity : AppCompatActivity() {
    private val homeFragment by lazy { HomeFragment() }
    private val searchFragment by lazy { SearchFragment() }
    private val mypageFragment by lazy { MypageFragment() }
    private lateinit var binding: ActivityHomeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initTransactionEvent()
    }

    private fun initTransactionEvent() {
        binding.bnvMain.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.menu_home -> {
                    changeFragment(homeFragment)
                }
                R.id.menu_search -> {
                    changeFragment(searchFragment)
                }
                R.id.menu_my_page -> {
                    changeFragment(mypageFragment)
                }
            }
            true
        }
        binding.bnvMain.selectedItemId = R.id.menu_home
    }

    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_home, fragment)
            .commit()
    }
}