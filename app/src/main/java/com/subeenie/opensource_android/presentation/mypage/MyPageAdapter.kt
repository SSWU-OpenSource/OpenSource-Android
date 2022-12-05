package com.subeenie.opensource_android.presentation.mypage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.subeenie.opensource_android.data.ScrapData
import com.subeenie.opensource_android.databinding.ItemScrapListBinding

class MyPageAdapter(private val itemClick: (ScrapData) -> (Unit)) :
    ListAdapter<ScrapData, MyPageAdapter.MyPageViewHolder>(DIFFUTIL) {
    private lateinit var itemClickListener: OnItemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyPageViewHolder {
        val binding =
            ItemScrapListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyPageViewHolder(binding, itemClick)

    }

    override fun onBindViewHolder(holder: MyPageViewHolder, position: Int) {
        holder.onBind(currentList[position])
    }

    class MyPageViewHolder(
        private val binding: ItemScrapListBinding,
        private val itemClick: (ScrapData) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(scrapData: ScrapData) {
            binding.scrap = scrapData
            binding.root.setOnClickListener {
                itemClick(scrapData)
            }
        }
    }

    companion object {
        val DIFFUTIL = object : DiffUtil.ItemCallback<ScrapData>() {
            override fun areItemsTheSame(
                oldItem: ScrapData,
                newItem: ScrapData
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: ScrapData,
                newItem: ScrapData
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