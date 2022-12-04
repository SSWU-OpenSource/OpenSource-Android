package com.subeenie.opensource_android.presentation.write

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.subeenie.opensource_android.R
import com.subeenie.opensource_android.databinding.ActivityHomeBinding
import com.subeenie.opensource_android.databinding.ActivityWriteBinding
import com.subeenie.opensource_android.presentation.home.HomeActivity

class WriteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWriteBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWriteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        gotoBack()
    }

    private fun gotoBack() {
        binding.btnBack.setOnClickListener {
            finish()
        }
        binding.btnComplete.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

}