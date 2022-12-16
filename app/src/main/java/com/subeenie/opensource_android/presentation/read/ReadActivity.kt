package com.subeenie.opensource_android.presentation.read

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.subeenie.opensource_android.R
import com.subeenie.opensource_android.ServiceCreator
import com.subeenie.opensource_android.databinding.ActivityReadBinding
import com.subeenie.opensource_android.databinding.ActivityWriteBinding
import com.subeenie.opensource_android.util.enqueueUtil
import kotlin.properties.Delegates

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
        val content = intent.getStringExtra("content")
        Log.e("read", "$title")
        Log.e("read", "$content")
        binding.apply {
            with(intent) {
                etTitle.text = getStringExtra("title")
                etContent.text = getStringExtra("content")
            }

        }

    }

    private fun gotoBack() {
        binding.btnBack.setOnClickListener {
            finish()
        }
    }
}

