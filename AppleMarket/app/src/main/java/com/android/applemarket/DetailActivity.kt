package com.android.applemarket

import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.applemarket.databinding.ActivityDetailBinding
import com.android.applemarket.databinding.ActivityMainBinding

class DetailActivity : AppCompatActivity() {
    private val binding by lazy { ActivityDetailBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val getData = intent.getParcelableExtra<Post>("data")
        getData?.let{
            binding.ivPhoto.setImageResource(it.itemPhoto)
            binding.tvNickname.text = it.nickName
            binding.tvLocation.text = it.itemLocation
            binding.tvTemperature.text = it.temperature
            binding.ivIcon.setImageResource(it.mannerImage)
            binding.tvName.text = it.itemName
            binding.tvDescription.text = it.description
        }

        // 텍스트에 밑줄 긋기
        binding.tvManner.paintFlags = Paint.UNDERLINE_TEXT_FLAG

        binding.ivBack.setOnClickListener {
            finish()
        }
    }
}