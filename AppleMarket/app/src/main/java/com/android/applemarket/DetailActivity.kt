package com.android.applemarket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.applemarket.databinding.ActivityDetailBinding
import java.text.DecimalFormat

class DetailActivity : AppCompatActivity() {
    private val binding by lazy { ActivityDetailBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val decimal = DecimalFormat("#,###")

        val getData = intent.getParcelableExtra<SaleItem>("data")
        getData?.let{
            binding.ivPhoto.setImageResource(it.itemPhoto)
            binding.tvNickname.text = it.nickName
            binding.tvLocation.text = it.itemLocation
            binding.tvTemperature.text = it.temperature
            binding.ivIcon.setImageResource(it.mannerImage)
            binding.tvName.text = it.itemName
            binding.tvDescription.text = it.description
            binding.tvPrice.text = decimal.format(it.itemPrice) + "원"
        }

        // binding.tvManner.paintFlags = Paint.UNDERLINE_TEXT_FLAG    // 텍스트에 밑줄

        binding.ivBack.setOnClickListener {
            finish()
        }
    }
}