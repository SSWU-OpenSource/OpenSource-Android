package com.subeenie.opensource_android.presentation.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.subeenie.opensource_android.R
import com.subeenie.opensource_android.databinding.FragmentHomeBinding
import com.subeenie.opensource_android.util.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

}