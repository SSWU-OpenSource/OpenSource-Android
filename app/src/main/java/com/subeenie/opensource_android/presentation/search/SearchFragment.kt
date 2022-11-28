package com.subeenie.opensource_android.presentation.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.subeenie.opensource_android.R
import com.subeenie.opensource_android.databinding.FragmentSearchBinding
import com.subeenie.opensource_android.util.BaseFragment


class SearchFragment : BaseFragment<FragmentSearchBinding>(R.layout.fragment_search) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = this

    }

}