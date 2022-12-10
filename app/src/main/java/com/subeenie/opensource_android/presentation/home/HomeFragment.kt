package com.subeenie.opensource_android.presentation.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.subeenie.opensource_android.R
import com.subeenie.opensource_android.data.BoardData
import com.subeenie.opensource_android.databinding.FragmentHomeBinding
import com.subeenie.opensource_android.presentation.write.WriteActivity
import com.subeenie.opensource_android.presentation.read.ReadActivity
import com.subeenie.opensource_android.util.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {
    private lateinit var boardAdapter: BoardAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = this
        initAdapter()
        addBoardList()

    }

    private fun initAdapter() {

        boardAdapter = BoardAdapter {
            val intent = Intent(activity, ReadActivity::class.java)
            intent.apply {
                intent.putExtra("id", it.id)
                intent.putExtra("title", it.title)
                intent.putExtra("user", it.user)
            }
            startActivity(intent)
        }
        binding.rvProductList.adapter = boardAdapter
    }


    private fun addBoardList() {
        boardAdapter.submitList(
            listOf(
                BoardData(
                    1, "게시글 제목 더미임", "김숩인"
                ),
                BoardData(
                    2, "게시글 제목 더미임", "김채니씨"
                ),
                BoardData(
                    3, "게시글 제목 더미임", "정순서씨"
                ),
                BoardData(
                    4, "게시글 제목 더미임", "유지니지니"
                ),
                BoardData(
                    5, "게시글 제목 더미임", "옾소스유저"
                ),
                BoardData(
                    6, "게시글 제목 더미임", "내가누구게"
                ),
                BoardData(
                    7, "게시글 제목 더미임", "도커씨"
                ),
                BoardData(
                    8, "게시글 제목 더미임", "젠킨스씨"
                ),
                BoardData(
                    9, "게시글 제목 더미임", "젠킨스씨"
                ),
                BoardData(
                    10, "게시글 제목 더미임", "젠킨스씨"
                ),
                BoardData(
                    11, "게시글 제목 더미임", "젠킨스씨"
                ),
                BoardData(
                    12, "게시글 제목 더미임", "젠킨스씨"
                ),
                BoardData(
                    13, "게시글 제목 더미임", "젠킨스씨"
                ),


                )
        )

    }

}