package com.android.applemarket

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import com.android.applemarket.databinding.ActivityDetailBinding
import com.google.android.material.snackbar.Snackbar
import java.text.DecimalFormat

class DetailActivity : AppCompatActivity() {
    private val binding by lazy { ActivityDetailBinding.inflate(layoutInflater) }

    private val item: SaleItem? by lazy {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(Constants.Item, SaleItem::class.java)
        } else {
            intent.getParcelableExtra<SaleItem>(Constants.Item)
        }
    }

    private val itemPosition: Int by lazy {
        intent.getIntExtra(Constants.index, 0)
    }

    private var isLike = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val decimal = DecimalFormat("#,###")

        // binding.ivPhoto.setImageResource(item?.itemPhoto) -> 에러
        item?.itemPhoto?.let { binding.ivPhoto.setImageResource(it) }
        binding.tvNickname.text = item?.nickName
        binding.tvLocation.text = item?.itemLocation
        binding.tvTemperature.text = item?.temperature
        // binding.ivIcon.setImageResource(item?.mannerImage) -> 에러
        item?.mannerImage?.let { binding.ivIcon.setImageResource(it) }
        binding.tvName.text = item?.itemName
        binding.tvDescription.text = item?.description
        binding.tvPrice.text = decimal.format(item?.itemPrice) + "원"

        isLike = item?.isLike == true

        binding.ivDetailLike.setImageResource(if (isLike) {R.drawable.like2}else{R.drawable.like})

        binding.ivBack.setOnClickListener {
            exit()
        }

        binding.llDetailLike.setOnClickListener {
            if(!isLike){
                binding.ivDetailLike.setImageResource(R.drawable.like2)
                Snackbar.make(binding.constLayout, "관심 목록에 추가되었습니다.", Snackbar.LENGTH_SHORT).show()
                isLike = true
            }else {
                binding.ivDetailLike.setImageResource(R.drawable.like)
                isLike = false
            }
        }
    }

    fun exit() {
        val intent = Intent(this, MainActivity::class.java).apply {
            putExtra(Constants.index, itemPosition)
            putExtra("isLike", isLike)
        }
        setResult(RESULT_OK, intent)
        if (!isFinishing) finish()
    }

    private val callback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            exit()
        }
    }
}