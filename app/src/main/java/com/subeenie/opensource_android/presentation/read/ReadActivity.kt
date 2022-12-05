package com.subeenie.opensource_android.presentation.read

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.subeenie.opensource_android.R
import com.subeenie.opensource_android.databinding.ActivityReadBinding
import com.subeenie.opensource_android.databinding.ActivityWriteBinding

class ReadActivity : AppCompatActivity() {
    private lateinit var binding: ActivityReadBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReadBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getData()
        gotoBack()
    }

    private fun getData() {
        val title = intent.getStringExtra("title")
        //val content = intent.getStringExtra("content")
        Log.e("read","$title")


        binding.apply {
            etTitle.text = title
            //etContent.text = content
        }

    }

    private fun gotoBack() {
        binding.btnBack.setOnClickListener {
            finish()
        }
    }
}