package com.subeenie.opensource_android.presentation.mypage

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.subeenie.opensource_android.R
import com.subeenie.opensource_android.data.BoardData
import com.subeenie.opensource_android.data.ScrapData
import com.subeenie.opensource_android.databinding.FragmentMypageBinding
import com.subeenie.opensource_android.presentation.detail.DetailActivity
import com.subeenie.opensource_android.presentation.home.BoardAdapter
import com.subeenie.opensource_android.presentation.write.WriteActivity
import com.subeenie.opensource_android.presentation.read.ReadActivity
import com.subeenie.opensource_android.util.BaseFragment


class MypageFragment : BaseFragment<FragmentMypageBinding>(R.layout.fragment_mypage) {

    private lateinit var myPageAdapter: MyPageAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = this
        initAdapter()
        addBoardList()
        itemClickEvent()
    }

    private fun initAdapter() {

        myPageAdapter = MyPageAdapter {
            val intent = Intent(activity, ReadActivity::class.java)
            intent.apply {
                intent.putExtra("id", it.id)
                intent.putExtra("title", it.title)
            }
            startActivity(intent)
        }
        binding.rcvScrap.adapter = myPageAdapter
    }

    private fun itemClickEvent() {
        myPageAdapter.setItemClickListener(object : MyPageAdapter.OnItemClickListener {
            override fun onClick(view: View, position: Int) {
                val title = myPageAdapter.currentList[position].title
                val id = myPageAdapter.currentList[position].id

                val intent = Intent(context, ReadActivity::class.java).apply {
                    putExtra("title", title)
                    putExtra("id", id)
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    Log.e("my","$id")
                }
                startActivity(intent)

            }

        })
    }

    private fun addBoardList() {
        myPageAdapter.submitList(
            listOf(
                ScrapData(
                    1, "게시글 제목 더미임"
                ),
                ScrapData(
                    2, "게시글 제목 더미임"
                ),
                ScrapData(
                    3, "게시글 제목 더미임"
                ),
                ScrapData(
                    4, "게시글 제목 더미임"
                ),
                ScrapData(
                    5, "게시글 제목 더미임"
                ),
                ScrapData(
                    6, "게시글 제목 더미임"
                ),
                ScrapData(
                    7, "게시글 제목 더미임"
                ),
                ScrapData(
                    8, "게시글 제목 더미임"
                ),
                ScrapData(
                    9, "게시글 제목 더미임"
                ),
                ScrapData(
                    10, "게시글 제목 더미임"
                ),
                ScrapData(
                    11, "게시글 제목 더미임"
                ),
                ScrapData(
                    12, "게시글 제목 더미임"
                )
            )
        )
    }

}
