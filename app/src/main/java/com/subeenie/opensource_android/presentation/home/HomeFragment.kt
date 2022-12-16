package com.subeenie.opensource_android.presentation.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.subeenie.opensource_android.R
import com.subeenie.opensource_android.ServiceCreator
import com.subeenie.opensource_android.data.BoardData
import com.subeenie.opensource_android.databinding.FragmentHomeBinding
import com.subeenie.opensource_android.presentation.detail.DetailActivity
import com.subeenie.opensource_android.presentation.write.WriteActivity
import com.subeenie.opensource_android.presentation.read.ReadActivity
import com.subeenie.opensource_android.util.BaseFragment
import com.subeenie.opensource_android.util.enqueueUtil

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {
    private var boardAdapter = BoardAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = this
        initAdapter()

    }

    private fun initAdapter() {

        binding.rvProductList.adapter = boardAdapter
        addBoardList()
        itemClickEvent()
    }

    private fun itemClickEvent() {
        boardAdapter.setItemClickListener(object : BoardAdapter.OnItemClickListener {
            override fun onClick(view: View, position: Int) {
                val id = boardAdapter.currentList[position].id
                val title = boardAdapter.currentList[position].title
                val content = boardAdapter.currentList[position].content

                val intent = Intent(context, ReadActivity::class.java).apply {
                    putExtra("id", id)
                    putExtra("title", title)
                    putExtra("content", content)
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                }
                startActivity(intent)

            }

        })
    }


    private fun addBoardList() {
        val call = ServiceCreator.boardService.getPostInfo()

        call.enqueueUtil(
            onSuccess = {
                Log.e("add", "success")
                boardAdapter.submitList(it.data.posts)
            }
        )

    }

}