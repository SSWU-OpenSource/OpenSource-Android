package com.subeenie.opensource_android.presentation.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.subeenie.opensource_android.data.BoardData
import com.subeenie.opensource_android.data.remote.response.ResponseBoard
import com.subeenie.opensource_android.databinding.ItemBoardListBinding

class BoardAdapter :
    ListAdapter<ResponseBoard.Data.Posts, BoardAdapter.BoardViewHolder>(DIFFUTIL) {

    private lateinit var itemClickListener: OnItemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoardViewHolder {
        val binding =
            ItemBoardListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BoardViewHolder(binding)

    }

    override fun onBindViewHolder(holder: BoardViewHolder, position: Int) {
        holder.onBind(currentList[position])
        holder.itemView.setOnClickListener {
            itemClickListener.onClick(it, position)
        }
    }

    class BoardViewHolder(
        private val binding: ItemBoardListBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(boardData: ResponseBoard.Data.Posts) {
            //binding.tvTitle.text = boardData.title
            binding.board = boardData
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
