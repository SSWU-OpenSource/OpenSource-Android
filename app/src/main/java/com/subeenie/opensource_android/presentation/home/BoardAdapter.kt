package com.subeenie.opensource_android.presentation.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.subeenie.opensource_android.data.BoardData
import com.subeenie.opensource_android.databinding.ItemBoardListBinding

class BoardAdapter(private val itemClick: (BoardData) -> (Unit)) :
    ListAdapter<BoardData, BoardAdapter.BoardViewHolder>(DIFFUTIL) {

    private lateinit var itemClickListener: OnItemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoardViewHolder {
        val binding =
            ItemBoardListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BoardViewHolder(binding, itemClick)

    }

    override fun onBindViewHolder(holder: BoardViewHolder, position: Int) {
        holder.onBind(currentList[position])
    }

    class BoardViewHolder(
        private val binding: ItemBoardListBinding,
        private val itemClick: (BoardData) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(boardData: BoardData) {
            binding.board = boardData
            binding.root.setOnClickListener {
                itemClick(boardData)
            }
        }
    }

    companion object {
        val DIFFUTIL = object : DiffUtil.ItemCallback<BoardData>() {
            override fun areItemsTheSame(
                oldItem: BoardData,
                newItem: BoardData
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: BoardData,
                newItem: BoardData
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