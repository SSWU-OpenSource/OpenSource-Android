package com.subeenie.opensource_android.presentation.mypage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.subeenie.opensource_android.data.remote.response.ResponseBoard
import com.subeenie.opensource_android.databinding.ItemScrapListBinding

class MyPageAdapter :
    ListAdapter<ResponseBoard.Data.Posts, MyPageAdapter.MyPageViewHolder>(DIFFUTIL) {
    private lateinit var itemClickListener: OnItemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyPageViewHolder {
        val binding =
            ItemScrapListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyPageViewHolder(binding)

    }

    override fun onBindViewHolder(holder: MyPageViewHolder, position: Int) {
        holder.onBind(currentList[position])
        holder.itemView.setOnClickListener {
            itemClickListener.onClick(it, position)

        }
    }

        class MyPageViewHolder(
            private val binding: ItemScrapListBinding,
        ) : RecyclerView.ViewHolder(binding.root) {
            fun onBind(scrapData: ResponseBoard.Data.Posts) {
                binding.scrap = scrapData
            }
        }

        companion object {
            val DIFFUTIL = object : DiffUtil.ItemCallback<ResponseBoard.Data.Posts>() {
                override fun areItemsTheSame(
                    oldItem: ResponseBoard.Data.Posts,
                    newItem: ResponseBoard.Data.Posts
                ): Boolean {
                    return oldItem.id == newItem.id
                }

                override fun areContentsTheSame(
                    oldItem: ResponseBoard.Data.Posts,
                    newItem: ResponseBoard.Data.Posts
                ): Boolean {
                    return oldItem == newItem
                }
            }
        }

        interface OnItemClickListener {
            fun onClick(data: View, position: Int)
        }

        fun setItemClickListener(itemClickListener: OnItemClickListener) {
            this.itemClickListener = itemClickListener
        }


    }
