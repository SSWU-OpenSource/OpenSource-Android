package com.subeenie.opensource_android.presentation.mypage

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import com.subeenie.opensource_android.R
import com.subeenie.opensource_android.ServiceCreator
import com.subeenie.opensource_android.databinding.FragmentMypageBinding
import com.subeenie.opensource_android.presentation.read.ReadActivity
import com.subeenie.opensource_android.util.BaseFragment
import com.subeenie.opensource_android.util.enqueueUtil


class MypageFragment : BaseFragment<FragmentMypageBinding>(R.layout.fragment_mypage) {

    private var myPageAdapter= MyPageAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = this
        initAdapter()

    }

    private fun initAdapter() {
        binding.rcvScrap.adapter = myPageAdapter
        addBoardList()
        itemClickEvent()
    }

    private fun itemClickEvent() {
        myPageAdapter.setItemClickListener(object : MyPageAdapter.OnItemClickListener {
            override fun onClick(view: View, position: Int) {
                val id = myPageAdapter.currentList[position].id
                val title = myPageAdapter.currentList[position].title
                val content = myPageAdapter.currentList[position].content

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
        val call = ServiceCreator.boardService.getScrapBoardInfo()

        call.enqueueUtil(
            onSuccess = {
                Log.e("add", "success")
                myPageAdapter.submitList(it.data.posts)
            }
        )
    }

}
